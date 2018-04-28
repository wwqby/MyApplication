package Model;

import android.widget.Toast;

import com.example.android.employeesystem_zy.LoginActivity;

public class UserLogin implements IUserLogin {

    @Override
    public void login(final String user, final String password, final OnLoginListener listener) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if ("wwq".equals(user) && "12345".equals(password)) {
                    listener.loginSuccessed();
                }else{
                    listener.loginFailed();
                }
            }
        }).start();
    }
}
