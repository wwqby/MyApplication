package Model;

/**
 * 版本更新接口
 */
public interface IUserLogin {

    /**
     * 登录功能
     */
    public void login(String Username,String password,OnLoginListener listener);
}
