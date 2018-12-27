package tutorial.navy.com.tutorial1;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private String[] items = {"망고 쥬스", "토마토 쥬스", "포도 쥬스"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button listButton = (Button) findViewById(R.id.listButton);
        listButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("리스트");
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        Toast.makeText(getApplicationContext(), items[i], Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        Button exitButton = (Button) findViewById(R.id.exitButton);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("정말로 종료하시겠습니까?");
                builder.setTitle("종료 알림창")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.setTitle("종료 알림창");
                dialog.show();
            }
        });
    }

    /**
     * 계산기; 덧셈 메서드
     * @param v
     */
    public void addClick(View v) {
        getResult(v, "add");
    }

    /**
     * 계산기; 빼기 메서드
     * @param v
     */
    public void subtractClick(View v) {
        getResult(v, "minus");
    }

    /**
     * 계산기; 곱하기 메서드
     * @param v
     */
    public void multiplyClick(View v) {
        getResult(v, "multiply");
    }

    /**
     * 계산기; 나누기 메서드
     * @param v
     */
    public void divideClick(View v) {
        getResult(v, "divide");
    }

    /**
     * 결과 받아오기
     * @param v
     * @param option
     */
    private void getResult(View v, String option) {
        EditText number1 = (EditText) findViewById(R.id.number1);
        EditText number2 = (EditText) findViewById(R.id.number2);
        TextView result = (TextView) findViewById(R.id.result);
        int n1 = Integer.parseInt(number1.getText().toString());
        int n2 = Integer.parseInt(number2.getText().toString());
        if ("add".equals(option)) {
            result.setText(Integer.toString(n1 + n2));
        } else if ("minus".equals(option)) {
            result.setText(Integer.toString(n1 - n2));
        } else if ("multiply".equals(option)) {
            result.setText(Integer.toString(n1 * n2));
        } else if ("divide".equals(option)) {
            result.setText(Integer.toString(n1 / n2));
        }

    }
}
