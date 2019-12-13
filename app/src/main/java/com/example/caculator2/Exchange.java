package com.example.caculator2;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Exchange<buttons>  extends AppCompatActivity implements View.OnClickListener{

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
                item.setIntent(new Intent(Exchange.this,MainActivity.class));
                break;
            case R.id.action_conversion:
                break;

        }
        return super.onOptionsItemSelected(item);
    }
    //下拉菜单

    Button  bt_C,bt_7,bt_8,bt_9,
            bt_point,bt_4,bt_5,bt_6,
            bt_0,bt_1,bt_2,bt_3,
            bt_equal;

    EditText screen;
    Double ten_result=null;
    int ten_entering=0;
    String spin,spinl;
    Spinner spinner,spinnerl;
    //判断屏幕是否为空
    boolean clear_flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);

        //判断屏幕是否为空
        boolean clear_flag;
        //获取屏幕的输入
        screen= (EditText) findViewById(R.id.screen);
        if(this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            bt_equal = (Button) findViewById(R.id.bt_equal);

            bt_C = (Button) findViewById(R.id.bt_C);
            bt_7 = (Button) findViewById(R.id.bt_7);
            bt_8 = (Button) findViewById(R.id.bt_8);
            bt_9 = (Button) findViewById(R.id.bt_9);

            bt_point = (Button) findViewById(R.id.bt_point);
            bt_4 = (Button) findViewById(R.id.bt_4);
            bt_5 = (Button) findViewById(R.id.bt_5);
            bt_6 = (Button) findViewById(R.id.bt_6);

            bt_0 = (Button) findViewById(R.id.bt_0);
            bt_1 = (Button) findViewById(R.id.bt_1);
            bt_2 = (Button) findViewById(R.id.bt_2);
            bt_3 = (Button) findViewById(R.id.bt_3);


            bt_equal.setOnClickListener(this);

            bt_C.setOnClickListener(this);
            bt_7.setOnClickListener(this);
            bt_8.setOnClickListener(this);
            bt_9.setOnClickListener(this);

            bt_point.setOnClickListener(this);
            bt_4.setOnClickListener(this);
            bt_5.setOnClickListener(this);
            bt_6.setOnClickListener(this);

            bt_0.setOnClickListener(this);
            bt_1.setOnClickListener(this);
            bt_2.setOnClickListener(this);
            bt_3.setOnClickListener(this);
        }

        spinner= (Spinner) findViewById(R.id.spinner_in);
        spinnerl= (Spinner) findViewById(R.id.spinner_out);

        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.items, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapterl=ArrayAdapter.createFromResource(this,R.array.itemsl, android.R.layout.simple_spinner_item);


        spinner.setAdapter(adapter);
        spinnerl.setAdapter(adapterl);

        spin=spinner.getSelectedItem().toString();
        //  Toast.makeText(this, spin, Toast.LENGTH_SHORT).show();
        spinl=spinnerl.getSelectedItem().toString();
        //显示下拉菜单
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            protected void onItemSelectedListener(AdapterView<?> adapterView, View view, int i, long l){
                if(i>0)
                    Toast.makeText(Exchange.this,adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }
            @Override
            public  void onNothingSelected(AdapterView<?> adapterView){

            }
        });

        spinnerl.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            protected void onItemSelectedListener(AdapterView<?> adapterView, View view, int i, long l){
                if(i>0)
                    Toast.makeText(Exchange.this,adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }
            @Override
            public  void onNothingSelected(AdapterView<?> adapterView){

            }
        });

    }
    @Override
    public void onClick(View v) {
        String str=screen.getText().toString();
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
            case R.id.bt_equal:
                getResult();
                break;
        }
    }
    private void getResult(){
        spin=spinner.getSelectedItem().toString();
        spinl=spinnerl.getSelectedItem().toString();
        String entering=screen.getText().toString();
        int i=0;
        int seat;
        String result = null;
        int ten_entering=0;
        char[] sc=spin.toCharArray();
        char[] slc=spinl.toCharArray();
        if(spin.indexOf("进制")!=-1&&spinl.indexOf("进制")!=-1){
            for (i=0;i<=sc.length-1;i++){
                if(sc[i] == '(' ) {
                    seat=spin.indexOf(")",i);
                    String coefficient="";
                    for(int j = i+1; j<seat; j++){
                        coefficient+=sc[j];//记录当前的系数
                    }
                    Toast.makeText(this, coefficient, Toast.LENGTH_SHORT).show();
                    int rdcoe =Integer.parseInt(coefficient);
                    //先转换成10进制
                    ten_entering=Integer.parseInt(entering,rdcoe);
                }
            }

            for (i=0;i<=slc.length-1;i++){
                if(slc[i] == '(' ) {
                    seat=spinl.indexOf(")",i);
                    String coefficientl="";
                    for(int j = i+1; j<seat; j++){
                        coefficientl+=slc[j];//记录当前的系数
                    }

                    int asc=Integer.parseInt(coefficientl);
                    if(asc==2)
                        result=Integer.toBinaryString(ten_entering);
                    else if(asc==8)
                        result=Integer.toOctalString(ten_entering);
                    else if(asc==10)
                        result=String.valueOf(ten_entering);
                    else if(asc==16)
                        result=Integer.toHexString(ten_entering);
                }
            }
        }

        //体积转换
        else if(spin.indexOf("m^3")!=-1&&spinl.indexOf("m^3")!=-1){
            if(spin.indexOf("米(m^3)")!=-1) {
                ten_result=Double.parseDouble(entering);
            }
            else if(spin.indexOf("分米")!=-1){
                ten_result=Double.parseDouble(entering)*Math.pow(10,-3);
            }
            else if(spin.indexOf("厘米")!=-1) {
                ten_result=Double.parseDouble(entering)*Math.pow(10,-6);
            }
            else if(spin.indexOf("毫米")!=-1) {
                ten_result=Double.parseDouble(entering)*Math.pow(10,-9);
            }

            if(spinl.indexOf("米(m^3)")!=-1) {
                result=String.valueOf(ten_result);
            }
            else if(spinl.indexOf("分米")!=-1){

                result=String.valueOf(ten_result*Math.pow(10,3));
            }
            else if(spinl.indexOf("厘米")!=-1) {
                result=String.valueOf(ten_result*Math.pow(10,6));
            }
            else if(spinl.indexOf("毫米")!=-1) {
                result=String.valueOf(ten_result*Math.pow(10,9));
            }
        }

        //汇率兑换
        else if((spin.indexOf("币")!=-1||spin.indexOf("元")!=-1||spin.indexOf("镑")!=-1)&&
                (spinl.indexOf("币")!=-1||spinl.indexOf("元")!=-1||spinl.indexOf("镑")!=-1)){
            if(spin.indexOf("CNY")!=-1) {
                ten_result=Double.parseDouble(entering);
            }
            else if(spin.indexOf("JPY")!=-1){
                ten_result=Double.parseDouble(entering)*0.06479;
            }
            else if(spin.indexOf("USD")!=-1) {
                ten_result=Double.parseDouble(entering)*7.0394;
            }
            else if(spin.indexOf("EUR")!=-1) {
                ten_result=Double.parseDouble(entering)*7.7947;
            }
            else if(spin.indexOf("GBP")!=-1) {
                ten_result=Double.parseDouble(entering)*9.0977;
            }

            if(spinl.indexOf("CNY")!=-1) {
                result=String.valueOf(ten_result);
            }
            else if(spinl.indexOf("JPY")!=-1){

                result=String.valueOf(ten_result*15.4346);
            }
            else if(spinl.indexOf("USD")!=-1) {
                result=String.valueOf(ten_result*0.1421);
            }
            else if(spinl.indexOf("EUR")!=-1) {
                result=String.valueOf(ten_result*0.1283);
            }
            else if(spinl.indexOf("GBP")!=-1) {
                result=String.valueOf(ten_result*0.1099);
            }
        }


        //长度转换
        else{
            System.out.println("re:");
            if(spin.indexOf("千米")!=-1) {
                ten_result=Double.parseDouble(entering)*Math.pow(10,3);
            }
            else if(spin.indexOf("米(m)")!=-1) {
                ten_result=Double.parseDouble(entering);
            }
            else if(spin.indexOf("分米")!=-1) {
                ten_result=Double.parseDouble(entering)*Math.pow(10,-1);
            }
            else if(spin.indexOf("厘米")!=-1) {
                ten_result=Double.parseDouble(entering)*Math.pow(10,-2);
            }
            else if(spin.indexOf("微米")!=-1) {
                ten_result=Double.parseDouble(entering)*Math.pow(10,-6);
            }
            else if(spin.indexOf("纳米")!=-1) {
                ten_result=Double.parseDouble(entering)*Math.pow(10,-9);
            }
            else if(spin.indexOf("皮米")!=-1) {
                ten_result=Double.parseDouble(entering)*Math.pow(10,-12);
            }

            if(spinl.indexOf("千米")!=-1) {
                result=String.valueOf(ten_result*Math.pow(10,-3));
            }
            else if(spinl.indexOf("米(m)")!=-1) {
                result=String.valueOf(ten_result);
            }
            else if(spinl.indexOf("分米")!=-1) {
                result=String.valueOf(ten_result*Math.pow(10,1));
            }
            else if(spinl.indexOf("厘米")!=-1) {
                result=String.valueOf(ten_result*Math.pow(10,2));
            }
            else if(spinl.indexOf("微米")!=-1) {
                result=String.valueOf(ten_result*Math.pow(10,6));
            }
            else if(spinl.indexOf("纳米")!=-1) {
                result=String.valueOf(ten_result*Math.pow(10,9));
            }
            else if(spinl.indexOf("皮米")!=-1) {
                result=String.valueOf(ten_result*Math.pow(10,12));

            }

        }

        if(clear_flag) {
            clear_flag = false;
            return;
        }
        clear_flag = true;
        screen.setText(result);
    }

}
