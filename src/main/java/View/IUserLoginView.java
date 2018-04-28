package View;

public interface IUserLoginView {
    /**
     * @return  获取用户名
     */
    public String getUserName();

    /**
     * @return 密码
     */
    public String getPassword();

    /**
     * 清除帐号信息
     */
    public void ClearUser();

    /**
     * 显示进度条
     */
    public void showProgressbar();

    /**
     * 隐藏进度条
     */
    public void hideProgreeBar();

    /**
     * 跳转主页
     */
    public void toMainActivity();

    /**
     * 显示登录失败提示框
     */
    public void loginFailedDialog();

}
