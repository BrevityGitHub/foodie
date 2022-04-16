package com.imooc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author mw
 * @version JDK 8
 * @date 2022/4/14 19:24
 */
@SpringBootApplication
@MapperScan(basePackages = "com.imooc.mapper")
public class Application {
	/**
	 * 事务传播 — Propagation
	 * REQUIRED：使用当前的事务，如果当前没有事务，则自己新建一个事务，子方法是必须运行在一个事务中的；
	 * 如果当前存在事务，则加入这个事务，成为一个整体。
	 * <p>
	 * SUPPORTS：如果当前有事务，则使用事务；如果当前没有事务，则不使用事务。
	 * <p>
	 * MANDATORY：该传播属性强制必须存在一个事务，如果不存在，则抛出异常。
	 * <p>
	 * REQUIRES_NEW：如果当前有事务，则挂起该事务，并且自己创建一个新的事务给自己使用；
	 * 如果当前没有事务，则同REQUIRED。
	 * <p>
	 * NOT_SUPPORTED：如果当前有事务，则把事务挂起，自己不使用事务去运行数据库操作。
	 * <p>
	 * NEVER：如果当前有事务存在，则抛出异常。
	 * <p>
	 * NESTED：如果当前有事务，则开启子事务(嵌套事务)，嵌套事务是独立提交或者回滚；
	 * 如果当前没有事务，则同REQUIRED，但是如果主事务提交，则会携带子事务一起提交；
	 * 如果主事务回滚，则子事务会一起回滚，相反，子事务异常，则父事务可以回滚或不回滚。
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
