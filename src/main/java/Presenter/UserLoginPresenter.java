package Presenter;

import Model.IUserLogin;
import Model.UserLogin;
import View.IUserLoginView;

/**
 * 登录管理
 */
public class UserLoginPresenter {
//    首先获取View和Model的实例
    private IUserLoginView mView;
    private IUserLogin mModel;
//    构造器传入View实例
    public UserLoginPresenter(IUserLoginView view){
        this.mModel=new UserLogin();
        this.mView=view;
    }
//    实现model方法
}
