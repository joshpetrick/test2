package com.josh.test.user;


import android.content.Context;
import android.os.AsyncTask;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Josh on 7/26/2016.
 * A way to use async tasks to improve db querying. Update to DB Handler?
 */
public class UserTaskHandler  {
    private String className;
    private String methodName;
    private Timestamp timeIn;
    private Timestamp timeOut;
    private UserDBHandler dbHandler;
    private Context toastContext;
    /*
    Constructor used to set initial variables needed
     */
    public UserTaskHandler(Context context, UserDBHandler db_Handler)
    {

        setDbHandler(db_Handler);
        setToastContext(context);

    }

    public void addUser(User temp)
    {
        Date temp1 = new Date(System.currentTimeMillis());
        setTimeIn(new Timestamp(temp1.getTime()));

        //create thread
       new AddUserTask().execute(temp);
        //Thread t = new Thread(new AddUserThread(temp));
        //t.start();

    }


    public class AddUserThread implements Runnable
    {
        private User user;

        public AddUserThread(User user) {
            this.user = user;
        }


        /**
         * Starts executing the active part of the class' code. This method is
         * called when a thread is started that has been created with a class which
         * implements {@code Runnable}.
         */
        @Override
        public void run() {
            System.out.println("Time in set at : "+getTimeIn());
            UserDBHandler temp = getDbHandler();
            temp.addUser(getUser());
            Date d = new Date(System.currentTimeMillis());

            System.out.println("Time out set to : "+new Timestamp(d.getTime()));
        }


        public User getUser() {
            return user;
        }
    }


    /* what to do
     * need to put querys into background process
      * what will querys need / do:
      * Create:
      *     can pass dbhandler through the parent class
      *     pass what needs created in the task params
      *
      *     return create a Toast & update list?
      * Retrieve:
      *
      *
      * Update:
      *
      * Delete:*/
    public class AddUserTask extends AsyncTask<User,Void,String>{


        /**
         * Override this method to perform a computation on a background thread. The
         * specified parameters are the parameters passed to {@link #execute}
         * by the caller of this task.
         * <p/>
         * This method can call {@link #publishProgress} to publish updates
         * on the UI thread.
         *
         * @param params The parameters of the task.
         * @return A result, defined by the subclass of this task.
         * @see #onPreExecute()
         * @see #onPostExecute
         * @see #publishProgress
         */
        @Override
        protected String doInBackground(User... params) {
            System.out.println("Time in set at : "+getTimeIn());
            UserDBHandler temp = getDbHandler();
            temp.addUser(params[0]);
            synchronized (this) {
                try {
                    wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Date d = new Date(System.currentTimeMillis());

            System.out.println("Time out set to : "+new Timestamp(d.getTime()));

            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        //could i start the activity again
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }
    }


    //Helper Functions


    public Context getToastContext() {
        return toastContext;
    }

    public void setToastContext(Context toastContext) {
        this.toastContext = toastContext;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Timestamp getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(Timestamp timeIn) {
        this.timeIn = timeIn;
    }

    public Timestamp getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(Timestamp timeOut) {
        this.timeOut = timeOut;
    }

    public UserDBHandler getDbHandler() {
        return dbHandler;
    }

    public void setDbHandler(UserDBHandler dbHandler) {
        this.dbHandler = dbHandler;
    }
}
