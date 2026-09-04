package com.jh;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jh.entity.User;
import com.jh.entity.UserAccount;
import com.jh.enums.StatusEnum;
import com.jh.service.UserAccountService;
import com.jh.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class Day07PracticeApplicationTests {

    @Resource
    private UserService userService;

    @Resource
    private UserAccountService userAccountService;

    // ========== A库（db1）任务 ==========

    // 任务一：新增用户（雪花算法ID、枚举状态、自动填充时间）
    @Test
    void testSaveUser() {
        User user = new User();
        user.setName("赵六")
            .setPassword("123456")
            .setStatus(StatusEnum.ACTIVE);
        boolean result = userService.save(user);
        System.out.println("新增结果：" + result);
        System.out.println("雪花算法ID：" + user.getId());
        System.out.println("状态：" + user.getStatus().getDesc());
        System.out.println("注册时间：" + user.getCreateTime());
        System.out.println("更新时间：" + user.getUpdateTime());
    }

    // 任务二：查询所有用户（password 不返回）
    @Test
    void testListUsers() {
        List<User> list = userService.list();
        list.forEach(u -> System.out.println(u));
        System.out.println("共查询到 " + list.size() + " 条记录");
    }

    // 任务三：使用 ActiveRecord 模式修改用户
    @Test
    void testActiveRecordUpdate() {
        User user = new User();
        user.setId(1L)
            .setName("张三丰")
            .setPassword("999999");
        boolean result = user.updateById();
        System.out.println("ActiveRecord修改结果：" + result);
    }

    // ========== B库（db2）任务 ==========

    // 任务四：动态数据源查询 db2 账户表
    @Test
    void testListAccounts() {
        List<UserAccount> list = userAccountService.list();
        list.forEach(System.out::println);
        System.out.println("共查询到 " + list.size() + " 条账户记录");
    }

    // 任务五：乐观锁修改账户余额
    @Test
    void testOptimisticLock() {
        // 先查询
        UserAccount account = userAccountService.getById(1L);
        System.out.println("修改前：" + account);

        // 修改余额
        account.setBalance(account.getBalance() + 500);
        boolean result = userAccountService.updateById(account);
        System.out.println("乐观锁修改结果：" + result);
        System.out.println("修改后版本号：" + account.getVersion());
    }

    // 任务六：模拟乐观锁失败（并发场景）
    @Test
    void testOptimisticLockFail() {
        UserAccount account1 = userAccountService.getById(2L);
        UserAccount account2 = userAccountService.getById(2L);
        System.out.println("原始版本号：" + account1.getVersion());

        account1.setBalance(account1.getBalance() + 100);
        boolean r1 = userAccountService.updateById(account1);
        System.out.println("第一次修改：" + r1 + "，版本号：" + account1.getVersion());

        account2.setBalance(account2.getBalance() + 200);
        boolean r2 = userAccountService.updateById(account2);
        System.out.println("第二次修改：" + r2 + "（版本号过期，应失败）");
    }
}
