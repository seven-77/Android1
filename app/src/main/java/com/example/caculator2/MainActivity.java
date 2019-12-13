package com.example.caculator2;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity<buttons> extends AppCompatActivity implements View.OnClickListener{

    //右上角菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();
        switch(id){
            case R.id.action_calculator:
                break;
            case R.id.action_conversion:
                item.setIntent(new Intent(MainActivity.this,Exchange.class));
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    //自动生成log常量：logt，ap，at... ...
     /*     {"bt_C","bt_division","bt_multi","bt_back","bt_7","bt_8","bt_9","bt_sub","bt_4","bt_5","bt_6","bt_add","bt_1","bt_2","bt_3","bt_percent","bt_0","bt_point","equal",
          "bt_eftbracket","bt_rightbracket","bt_IPF","bt_square","bt_cube","bt_pai","bt_factorial","bt_SOE","bt_SOE3","bt_e","bt_ln","bt_log","bt_sin","bt_cos","bt_tan"};
    private int []ids=new int[]{R.id.bt_leftbracket,R.id.bt_rightbracket,R.id.bt_IPF,R.id.bt_C,R.id.bt_division,R.id.bt_multi,R.id.bt_back,
            R.id.bt_square,R.id.bt_cube,R.id.bt_pai,R.id.bt_7,R.id.bt_8,R.id.bt_9,R.id.bt_sub,
            R.id.bt_factorial,R.id.bt_SOE,R.id.bt_SOE3,R.id.bt_4,R.id.bt_5,R.id.bt_6,R.id.bt_add,
            R.id.bt_e,R.id.bt_ln,R.id.bt_log,R.id.bt_1,R.id.bt_2,R.id.bt_3,R.id.bt_equal,
            R.id.bt_sin,R.id.bt_cos,R.id.bt_tan,R.id.bt_percent,R.id.bt_0,R.id.bt_point};
   */


    Button bt_leftbracket,bt_rightbracket,bt_IPF,bt_C,bt_division,bt_multi,bt_back,
            bt_square,bt_cube,bt_pai,bt_7,bt_8,bt_9,bt_sub,
            bt_factorial,bt_SOE,bt_SOE3,bt_4,bt_5,bt_6,bt_add,
            bt_e,bt_ln,bt_log,bt_1,bt_2,bt_3,bt_equal,
            bt_sin,bt_cos,bt_tan,bt_percent,bt_0,bt_point;

    EditText screen;

    //判断屏幕是否为空
    boolean clear_flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取屏幕的输入
        screen=(EditText)findViewById(R.id.screen);

        //实例化对象并设置点击事件
        //如果当前页面是横屏时候，实例化对象
        if(this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            bt_leftbracket=(Button)findViewById(R.id.bt_leftbracket);
            bt_rightbracket=(Button)findViewById(R.id.bt_rightbracket);
            bt_IPF=(Button)findViewById(R.id.bt_IPF);
            bt_C=(Button)findViewById(R.id.bt_C);
            bt_division=(Button)findViewById(R.id.bt_division);
            bt_multi=(Button)findViewById(R.id.bt_multi);
            bt_back=(Button)findViewById(R.id.bt_back);

            bt_square=(Button)findViewById(R.id.bt_square);
            bt_cube=(Button)findViewById(R.id.bt_cube);
            bt_pai=(Button)findViewById(R.id.bt_pai);
            bt_7=(Button)findViewById(R.id.bt_7);
            bt_8=(Button)findViewById(R.id.bt_8);
            bt_9=(Button)findViewById(R.id.bt_9);
            bt_sub=(Button)findViewById(R.id.bt_sub);

            bt_factorial=(Button)findViewById(R.id.bt_factorial);
            bt_SOE=(Button)findViewById(R.id.bt_SOE);
            bt_SOE3=(Button)findViewById(R.id.bt_SOE3);
            bt_4=(Button)findViewById(R.id.bt_4);
            bt_5=(Button)findViewById(R.id.bt_5);
            bt_6=(Button)findViewById(R.id.bt_6);
            bt_add=(Button)findViewById(R.id.bt_add);

            bt_e=(Button)findViewById(R.id.bt_e);
            bt_ln=(Button)findViewById(R.id.bt_ln);
            bt_log=(Button)findViewById(R.id.bt_log);
            bt_1=(Button)findViewById(R.id.bt_1);
            bt_2=(Button)findViewById(R.id.bt_2);
            bt_3=(Button)findViewById(R.id.bt_3);
            bt_equal=(Button)findViewById(R.id.bt_equal);

            bt_sin=(Button)findViewById(R.id.bt_sin);
            bt_cos=(Button)findViewById(R.id.bt_cos);
            bt_tan=(Button)findViewById(R.id.bt_tan);
            bt_percent=(Button)findViewById(R.id.bt_help);
            bt_0=(Button)findViewById(R.id.bt_0);
            bt_point=(Button)findViewById(R.id.bt_point);

            //给按钮设置点击事件；
            bt_leftbracket.setOnClickListener(this);
            bt_rightbracket.setOnClickListener(this);
            bt_IPF.setOnClickListener(this);
            bt_C.setOnClickListener(this);
            bt_division.setOnClickListener(this);
            bt_multi.setOnClickListener(this);
            bt_back.setOnClickListener(this);

            bt_square.setOnClickListener(this);
            bt_cube.setOnClickListener(this);
            bt_pai.setOnClickListener(this);
            bt_7.setOnClickListener(this);
            bt_8.setOnClickListener(this);
            bt_9.setOnClickListener(this);
            bt_sub.setOnClickListener(this);

            bt_factorial.setOnClickListener(this);
            bt_SOE.setOnClickListener(this);
            bt_SOE3.setOnClickListener(this);
            bt_4.setOnClickListener(this);
            bt_5.setOnClickListener(this);
            bt_6.setOnClickListener(this);
            bt_add.setOnClickListener(this);

            bt_e.setOnClickListener(this);
            bt_ln.setOnClickListener(this);
            bt_log.setOnClickListener(this);
            bt_1.setOnClickListener(this);
            bt_2.setOnClickListener(this);
            bt_3.setOnClickListener(this);
            bt_equal.setOnClickListener(this);

            bt_sin.setOnClickListener(this);
            bt_cos.setOnClickListener(this);
            bt_tan.setOnClickListener(this);
            bt_percent.setOnClickListener(this);
            bt_0.setOnClickListener(this);
            bt_point.setOnClickListener(this);
        }


        //当前页面是竖屏，实例化对象
        else
        {
            bt_C=(Button)findViewById(R.id.bt_C);
            bt_division=(Button)findViewById(R.id.bt_division);
            bt_multi=(Button)findViewById(R.id.bt_multi);
            bt_back=(Button)findViewById(R.id.bt_back);

            bt_7=(Button)findViewById(R.id.bt_7);
            bt_8=(Button)findViewById(R.id.bt_8);
            bt_9=(Button)findViewById(R.id.bt_9);
            bt_sub=(Button)findViewById(R.id.bt_sub);

            bt_4=(Button)findViewById(R.id.bt_4);
            bt_5=(Button)findViewById(R.id.bt_5);
            bt_6=(Button)findViewById(R.id.bt_6);
            bt_add=(Button)findViewById(R.id.bt_add);

            bt_1=(Button)findViewById(R.id.bt_1);
            bt_2=(Button)findViewById(R.id.bt_2);
            bt_3=(Button)findViewById(R.id.bt_3);
            bt_equal=(Button)findViewById(R.id.bt_equal);

            bt_percent=(Button)findViewById(R.id.bt_help);
            bt_0=(Button)findViewById(R.id.bt_0);
            bt_point=(Button)findViewById(R.id.bt_point);


            //并设置点击事件
            bt_C.setOnClickListener(this);
            bt_division.setOnClickListener(this);
            bt_multi.setOnClickListener(this);
            bt_back.setOnClickListener(this);

            bt_7.setOnClickListener(this);
            bt_8.setOnClickListener(this);
            bt_9.setOnClickListener(this);
            bt_sub.setOnClickListener(this);


            bt_4.setOnClickListener(this);
            bt_5.setOnClickListener(this);
            bt_6.setOnClickListener(this);
            bt_add.setOnClickListener(this);

            bt_1.setOnClickListener(this);
            bt_2.setOnClickListener(this);
            bt_3.setOnClickListener(this);
            bt_equal.setOnClickListener(this);

            bt_percent.setOnClickListener(this);
            bt_0.setOnClickListener(this);
            bt_point.setOnClickListener(this);

        }
    }


    @Override
    public void onClick(View v) {

        //获取输入的算式并赋值给str
        String str=screen.getText().toString();

        // screen.setText("111");//测试屏幕是否可以输出
        switch(v.getId())
        {
            case R.id.bt_0:
            case R.id.bt_1:
            case R.id.bt_2:
            case R.id.bt_3:
            case R.id.bt_4:
            case R.id.bt_5:
            case R.id.bt_6:
            case R.id.bt_7:
            case R.id.bt_8:
            case R.id.bt_9:
            case R.id.bt_point:
            case R.id.bt_add:
            case R.id.bt_sub:
            case R.id.bt_multi:
            case R.id.bt_division:
            case R.id.percent:

            case R.id.bt_leftbracket:
            case R.id.bt_rightbracket:


            case R.id.bt_IPF:
            case R.id.bt_square:
            case R.id.bt_cube:

            case R.id.bt_pai:
            case R.id.bt_e:
            case R.id.bt_factorial:

            case R.id.bt_SOE:
            case R.id.bt_SOE3:
            case R.id.bt_ln:
            case R.id.bt_log:
            case R.id.bt_sin:
            case R.id.bt_cos:
            case R.id.bt_tan:


                if(clear_flag)//如果屏幕为空
                {
                    clear_flag=false;
                    str="";//屏幕字符串为空
                    screen.setText("");//设置屏幕值为空
                }
                screen.setText(str+((Button)v).getText());//这只屏幕显示为当前
                break;


            case R.id.bt_C://清空屏幕
                if(clear_flag)
                    clear_flag=false;
                str="";
                screen.setText("");

                break;

            case R.id.bt_back://后退一格
                if(clear_flag)
                {
                    clear_flag=false;
                    str="";
                    screen.setText("");
                }

                else if(str!=null&&!str.equals(""))
                {
                    screen.setText(str.substring(0,str.length()-1));//显示减1
                    str=str.substring(0,str.length()-1);
                }
                break;
            case R.id.bt_equal:
                getResult();
                break;

            case R.id.bt_help:
                Toast.makeText(MainActivity.this,"帮助",Toast.LENGTH_SHORT).show();
                break;
        }

    }
    public int factN(int n){
        if(n == 1 || n==0){
            return 1;
        }else{
            return n*factN(n - 1);
        }
    }
    /*四个数中找出最大值*/
    static int max(int seat1,int seat2,int seat3,int seat4)
    {int seat;
        int m,n;
        if(seat1>seat2)
            m=seat1;
        else m=seat2;
        if(seat3>seat4)
            n=seat3;
        else n=seat4;
        if(m>n)
            seat=m;
        else seat=n;
        return seat;
    }
    private void getResult(){
        String entering=screen.getText().toString();
        String eresult =null;
        //切割字符串，进行转换特殊符号
        char[] b=entering.toCharArray();
        //数字在符号左边
        int seat1,seat2,seat3,seat4,seat; //记录1/x的系数 的开始位置减1 的值。
        int count=0;//记录符号出现的次数
        int i;
        while(entering.indexOf("π")!=-1||entering.indexOf("e")!=-1) {
            for (i=0;i<=b.length-1;i++) {
                if (b[i] == 'π')
                {
                    count++;
                    seat1=entering.lastIndexOf("+",i);//记录1/x的系数 的开始位置减1 的值。
                    seat2=entering.lastIndexOf("-",i);
                    seat3=entering.lastIndexOf("✖",i);
                    seat4=entering.lastIndexOf("/",i);

                    seat=max(seat1,seat2,seat3,seat4);
                    String coefficient="";
                    for( int j = seat + 1; j<i; j++)
                    {
                        coefficient+=b[j];
                    }
                    double rdcoe;
                    if(coefficient.equals(""))
                        rdcoe =Math.PI;
                    else
                        rdcoe =Double.parseDouble(coefficient)*Math.PI;

                    String srdcoe=String.valueOf(rdcoe);
                    String split_data=coefficient.concat("π");
                    if(count==1) {
                        eresult=entering.replace(split_data,srdcoe);
                    }
                    else
                        eresult= eresult.replace(split_data,srdcoe);

                }
                else if(b[i]=='e')
                {
                    count++;
                    seat1=entering.lastIndexOf("+",i);//记录1/x的系数 的开始位置减1 的值。
                    seat2=entering.lastIndexOf("-",i);
                    seat3=entering.lastIndexOf("✖",i);
                    seat4=entering.lastIndexOf("/",i);

                    seat=max(seat1,seat2,seat3,seat4);
                    String coefficient="";
                    for( int j = seat + 1; j<i; j++)
                    {
                        coefficient+=b[j];
                    }
                    double rdcoe;
                    if(coefficient.equals(""))
                        rdcoe =Math.E;
                    else
                        rdcoe =Double.parseDouble(coefficient)*Math.PI;

                    String srdcoe=String.valueOf(rdcoe);
                    String split_data=coefficient.concat("e");
                    if(count==1) {
                        eresult=entering.replace(split_data,srdcoe);
                    }
                    else
                        eresult= eresult.replace(split_data,srdcoe);

                }
            }
            break;
        }
        while(entering.indexOf("x")!=-1) {//待计算字符串中有X,解决1/x，x^2.x^3的存在判断问题，为-1表示不存在这些多项式。
            for (i=0;i<=b.length-4;i++) {//解决如果存在多个同类计算的问题。
                if (b[i] == '(' && b[i+1] == '1' && b[i+2] == '/' && b[i+3]== 'x' && b[i+4] == ')') {
                    count++;
                    seat1=entering.lastIndexOf("+",i);//记录1/x的系数 的开始位置减1 的值。
                    seat2=entering.lastIndexOf("-",i);
                    seat3=entering.lastIndexOf("✖",i);
                    seat4=entering.lastIndexOf("/",i);

                    seat=max(seat1,seat2,seat3,seat4);

                    String coefficient="";
                    for(int j = seat + 1; j<i; j++)
                    {
                        coefficient+=b[j];//记录当前1/X的系数
                    }

                    double rdcoe =1/Double.parseDouble(coefficient);//r:1/x计算结果，d：double类型的，coe：系数
                    String srdcoe=String.valueOf(rdcoe);
                    String split_data=coefficient.concat("(1/x)");//用运算结果代替有系数的多项式运算

                    if(count==1) {
                        eresult=entering.replace(split_data,srdcoe);
                    }
                    else
                        eresult= eresult.replace(split_data,srdcoe);


                }
                else if (b[i] == 'x' && b[i+1] == '^' && b[i+2] == '2'){
                    count++;

                    seat1=entering.lastIndexOf("+",i);//记录1/x的系数 的开始位置减1 的值。
                    seat2=entering.lastIndexOf("-",i);
                    seat3=entering.lastIndexOf("✖",i);
                    seat4=entering.lastIndexOf("/",i);

                    seat=max(seat1,seat2,seat3,seat4);

                    String coefficient="";
                    for(int j = seat + 1; j<i; j++)
                    {
                        coefficient+=b[j];//记录当前1/X的系数
                    }

                    double rdcoe =Double.parseDouble(coefficient)*Double.parseDouble(coefficient);//r:1/x计算结果，d：double类型的，coe：系数
                    String srdcoe=String.valueOf(rdcoe);
                    String split_data=coefficient.concat("x^2");//用运算结果代替有系数的多项式运算

                    if(count==1) {
                        eresult=entering.replace(split_data,srdcoe);
                    }
                    else
                        eresult= eresult.replace(split_data,srdcoe);

                }
                else if (b[i] == 'x' && b[i+1] == '^' && b[i+2] == '3'){
                    count++;

                    seat1=entering.lastIndexOf("+",i);//记录1/x的系数 的开始位置减1 的值。
                    seat2=entering.lastIndexOf("-",i);
                    seat3=entering.lastIndexOf("✖",i);
                    seat4=entering.lastIndexOf("/",i);

                    seat=max(seat1,seat2,seat3,seat4);
                    String coefficient="";
                    for(int j = seat + 1; j<i; j++)
                    {
                        coefficient+=b[j];//记录当前1/X的系数
                    }

                    double rdcoe =Double.parseDouble(coefficient)*Double.parseDouble(coefficient)*Double.parseDouble(coefficient);//r:1/x计算结果，d：double类型的，coe：系数
                    String srdcoe=String.valueOf(rdcoe);
                    String split_data=coefficient.concat("x^2");//用运算结果代替有系数的多项式运算

                    if(count==1) {
                        eresult=entering.replace(split_data,srdcoe);
                    }
                    else
                        eresult= eresult.replace(split_data,srdcoe);

                }
                else if (b[i] == 'x' && b[i+1] == '!'){
                    count++;

                    seat1=entering.lastIndexOf("+",i);//记录1/x的系数 的开始位置减1 的值。
                    seat2=entering.lastIndexOf("-",i);
                    seat3=entering.lastIndexOf("✖",i);
                    seat4=entering.lastIndexOf("/",i);

                    seat=max(seat1,seat2,seat3,seat4);

                    String coefficient="";
                    for(int j = seat + 1; j<i; j++)
                    {
                        coefficient+=b[j];//记录当前1/X的系数
                    }

                    double rdcoe =Double.parseDouble(coefficient)*Double.parseDouble(coefficient)*Double.parseDouble(coefficient);//r:1/x计算结果，d：double类型的，coe：系数
                    String srdcoe=String.valueOf(rdcoe);
                    String split_data=coefficient.concat("x^2");//用运算结果代替有系数的多项式运算

                    if(count==1) {
                        eresult=entering.replace(split_data,srdcoe);
                    }
                    else
                        eresult= eresult.replace(split_data,srdcoe);

                }
            }
            break;
        }
        while(entering.indexOf('√')!=-1||entering.indexOf("3√")!=-1||entering.indexOf("ln")!=-1||
                entering.indexOf("log")!=-1||entering.indexOf("sin")!=-1||entering.indexOf("cos")!=-1||entering.indexOf("tan")!=-1){
            for (i=0;i<=b.length-3;i++)
            {
                if(b[i] == '√' && b[i+1] == '(' ){
                    count++;
                    seat=entering.indexOf(")",i+1);

                    String coefficient="";
                    for(int j=i+2; j<seat; j++)
                    {
                        coefficient+=b[j];//记录当前1/X的系数
                    }

                    double rdcoe =Math.sqrt(Double.parseDouble(coefficient));//r:1/x计算结果，d：double类型的，coe：系数
                    String srdcoe=String.valueOf(rdcoe);
                    String split_data="√(".concat(coefficient).concat(")");//用运算结果代替有系数的多项式运算

                    if(count==1) {
                        eresult=entering.replace(split_data,srdcoe);
                    }
                    else
                        eresult= eresult.replace(split_data,srdcoe);

                }
                else if(b[i] == '3' && b[i+1] == '√' && b[i+2] == '(' ){
                    count++;
                    seat=entering.indexOf(")",i);

                    String coefficient="";
                    for(int j=i+3; j<seat; j++)
                    {
                        coefficient+=b[j];//记录当前的系数
                    }

                    double rdcoe =Math.pow(Double.parseDouble(coefficient),1/3.0);//r:1/x计算结果，d：double类型的，coe：系数
                    String srdcoe=String.valueOf(rdcoe);
                    String split_data="3√(".concat(coefficient).concat(")");//用运算结果代替有系数的多项式运算

                    if(count==1) {
                        eresult=entering.replace(split_data,srdcoe);
                    }
                    else
                        eresult= eresult.replace(split_data,srdcoe);

                }
                else if(b[i] == 'l' && b[i+1] == 'n' && b[i+2] == '(' ){
                    count++;
                    seat=entering.indexOf(")",i);

                    String coefficient="";
                    for(int j=i+3; j<seat; j++)
                    {
                        coefficient+=b[j];//记录当前1/X的系数
                    }

                    double rdcoe =Math.log(Double.parseDouble(coefficient))/(Math.log(Math.E));//r:1/x计算结果，d：double类型的，coe：系数
                    String srdcoe=String.valueOf(rdcoe);
                    String split_data="ln(".concat(coefficient).concat(")");//用运算结果代替有系数的多项式运算

                    if(count==1) {
                        eresult=entering.replace(split_data,srdcoe);
                    }
                    else
                        eresult= eresult.replace(split_data,srdcoe);

                }
                else if(b[i] == 'l' && b[i+1] == 'o' && b[i+2] == 'g'&& b[i+3] == '(' ){
                    count++;
                    seat=entering.indexOf(")",i);

                    String coefficient="";
                    for(int j=i+4; j<seat; j++)
                    {
                        coefficient+=b[j];//记录当前1/X的系数
                    }

                    double rdcoe =Math.log(Double.parseDouble(coefficient));//r:1/x计算结果，d：double类型的，coe：系数
                    String srdcoe=String.valueOf(rdcoe);
                    String split_data="log(".concat(coefficient).concat(")");//用运算结果代替有系数的多项式运算

                    if(count==1) {
                        eresult=entering.replace(split_data,srdcoe);
                    }
                    else
                        eresult= eresult.replace(split_data,srdcoe);

                }
                else if(b[i] == 's' && b[i+1] == 'i' && b[i+2] == 'n'&& b[i+3] == '(' ){
                    count++;
                    seat=entering.indexOf(")",i);

                    String coefficient="";
                    for(int j=i+4; j<seat; j++)
                    {
                        coefficient+=b[j];//记录当前1/X的系数
                    }

                    double rdcoe =Math.sin(Double.parseDouble(coefficient));//r:1/x计算结果，d：double类型的，coe：系数
                    String srdcoe=String.valueOf(rdcoe);
                    String split_data="sin(".concat(coefficient).concat(")");//用运算结果代替有系数的多项式运算

                    if(count==1) {
                        eresult=entering.replace(split_data,srdcoe);
                    }
                    else
                        eresult= eresult.replace(split_data,srdcoe);

                }
                else if(b[i] == 'c' && b[i+1] == 'o' && b[i+2] == 's'&& b[i+3] == '(' ){
                    count++;
                    seat=entering.indexOf(")",i);

                    String coefficient="";
                    for(int j=i+4; j<seat; j++)
                    {
                        coefficient+=b[j];//记录当前1/X的系数
                    }

                    double rdcoe =Math.cos(Double.parseDouble(coefficient));//r:1/x计算结果，d：double类型的，coe：系数
                    String srdcoe=String.valueOf(rdcoe);
                    String split_data="cos(".concat(coefficient).concat(")");//用运算结果代替有系数的多项式运算

                    if(count==1) {
                        eresult=entering.replace(split_data,srdcoe);
                    }
                    else
                        eresult= eresult.replace(split_data,srdcoe);

                }
                else if(b[i] == 't' && b[i+1] == 'a' && b[i+2] == 'n'&& b[i+3] == '(' ){
                    count++;
                    seat=entering.indexOf(")",i);

                    String coefficient="";
                    for(int j=i+4; j<seat; j++)
                    {
                        coefficient+=b[j];//记录当前1/X的系数
                    }

                    double rdcoe =Math.tan(Double.parseDouble(coefficient));//r:1/x计算结果，d：double类型的，coe：系数
                    String srdcoe=String.valueOf(rdcoe);
                    String split_data="tan(".concat(coefficient).concat(")");//用运算结果代替有系数的多项式运算

                    if(count==1) {
                        eresult=entering.replace(split_data,srdcoe);
                    }
                    else
                        eresult= eresult.replace(split_data,srdcoe);

                }




            }
            break;
        }
        if(count==0)
        {eresult=entering;}

        //数字在符号右边

        //数字在符号左边或者右边
        if(entering==null||entering.equals("")) return;

        if(clear_flag) {
            clear_flag = false;
            return;
        }
        Calculator ca = new Calculator();
        String value = null;
        clear_flag = true;
        value = eresult;
        String result = ca.getEventuate(value);
        screen.setText(result);

    }

}

