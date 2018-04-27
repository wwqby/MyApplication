package com.example.zy.myapplication.Utils;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * 所有的活动应该继承自这个基类
 */
public class AppActivity {

    /**
     * 单例模式实现mActivityManager
     */
    public static volatile AppActivity mAppActivity;

    /**
     * 私有的存放活动的列表
     */
    private List<Activity> mActivity=new ArrayList<Activity>();

    /**
     * 单例模式,私有的构造器
     */
    private AppActivity(){;
    }

    /**
     * @return 唯一的ActivityManager实例
     */
    public static AppActivity getInstance(){
        if (mAppActivity !=null){
            synchronized (AppActivity.class){
                if (mAppActivity != null)
                    mAppActivity = new AppActivity();
            }
        }
        return mAppActivity;
    }

    /**
     * @param activity 新的活动
     *  添加活动
     */
    public void addActivity(Activity activity){
        if (!mActivity.contains(activity)){
            mActivity.add(activity);
        }
    }

    /**
     * 关闭指定的活动
     * @param activity 需要关闭的活动
     */
    public void removeActivity(Activity activity){
        if (mActivity!=null){
            if (mActivity.contains(activity)){
                mActivity.remove(activity);
            }
            activity.finish();
            activity=null;
        }
    }

    /**
     * 关闭所有活动
     */
    public void clearAll(){
        if (mActivity!=null){
            for (Activity activity:mActivity){
                removeActivity(activity);
            }
        }
    }

    /**
     * 关闭除了MainActivity以外的其他活动
     */
    public void clearOther(){
        if (mActivity!=null){
            for (Activity activity:mActivity){
                if (activity.getClass().getSimpleName().equals("MainActivity")){
                    continue;
                }
                removeActivity(activity);
            }
        }
    }
}
