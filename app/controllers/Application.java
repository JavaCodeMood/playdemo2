package controllers;

import play.*;
import play.db.jpa.JPA;
import play.mvc.*;
import play.mvc.results.Result;

import java.util.*;

import javax.persistence.Query;

import models.*;

/**
 * 
 * 
 * @description
 * 
 * @author liuhefei
 * @createDate 2017年8月5日
 */
public class Application extends Controller {

    public static void index() {
    	//三种查询方法
//    	Query query = JPA.em().createNativeQuery("select * from user");
//    	Query query = JPA.em().createQuery("select * from User"); 
    	
    	/*Query query = JPA.em().createQuery("from User");
        List<User> user = query.getResultList();
        render(user);*/

        render();  
    }
    
    /**
     * 用户查询
     *
     * @author liuhefei
     * @createDate 2017年8月5日
     */
    public static void queryList() {
    	List<User> users=User.findAll();  
        for(User u:users){  
            System.out.println(u.username+"->"+u.email+"->"+u.password);  
        }  
        render(users);  
    }
    
    /**
     * 用户插入
     * 
     * @author liuhefei
     * @createDate 2017年8月5日
     */
    public static void insertList(){
    	User u1 = new User();
    	u1.username = "vamei";
    	u1.password = "play";
    	u1.email = "sdsdh@126.com";
    	u1.save();
        render(u1);
    }
    
    /**
     * 用户注册
     * @param user
     *
     * @author liuhefei
     * @createDate 2017年8月5日
     */
    public static void regist(User user){
    	user.save();
    	System.out.println(user.username);
    	render(user);
    }
    
    /**
     * 修改用户
     * 
     * @author liuhefei
     * @createDate 2017年8月5日
     */
    public static void updateList(){
    	long id = 2;
    	User user = User.findById(id);
    	user.username = "刘豆豆";
    	user.email = "liudoudou@126.com";
    	user.save();
    	render(user);
    }

    /**
     * 删除用户
     * 
     * @author liuhefei
     * @createDate 2017年8月5日
     */
    public static void deleteList(long id){
    	//long id = 5;
    	User u = User.findById(id);
    	u.delete();
    	String str = "数据删除成功！";
    	render(str);
    }

}