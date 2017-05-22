package sai.sondarkar.`in`.calculatordemowithkotlin


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView



class MainActivity : AppCompatActivity(), View.OnClickListener {


    private lateinit var etNum1: EditText
    private lateinit  var etNum2: EditText

    private lateinit  var btnAdd: Button
    private lateinit  var btnSub: Button
    private lateinit  var btnMult: Button
    private lateinit  var btnDiv: Button

    private lateinit  var tvResult: TextView

    internal var oper = ""

    /** Called when the activity is first created.  */
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // find the elements
        etNum1 = findViewById(R.id.etNum1) as EditText
        etNum2 = findViewById(R.id.etNum2) as EditText

        btnAdd = findViewById(R.id.btnAdd) as Button
        btnSub = findViewById(R.id.btnSub) as Button
        btnMult = findViewById(R.id.btnMult) as Button
        btnDiv = findViewById(R.id.btnDiv) as Button

        tvResult = findViewById(R.id.tvResult) as TextView

        // set a listener
        btnAdd.setOnClickListener(this)
        btnSub.setOnClickListener(this)
        btnMult.setOnClickListener(this)
        btnDiv.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        // TODO Auto-generated method stub
        var num1 = 0f
        var num2 = 0f
        var result = 0f

        // check if the fields are empty
        if (TextUtils.isEmpty(etNum1.text.toString()) || TextUtils.isEmpty(etNum2.text.toString())) {
            return
        }

        // read EditText and fill variables with numbers
        num1 = java.lang.Float.parseFloat(etNum1.text.toString())
        num2 = java.lang.Float.parseFloat(etNum2.text.toString())

        // defines the button that has been clicked and performs the corresponding operation
        // write operation into oper, we will use it later for output
        when (v.id) {
            R.id.btnAdd -> {
                oper = "+"
                result = num1 + num2
            }
            R.id.btnSub -> {
                oper = "-"
                result = num1 - num2
            }
            R.id.btnMult -> {
                oper = "*"
                result = num1 * num2
            }
            R.id.btnDiv -> {
                oper = "/"
                result = num1 / num2
            }
            else -> {
            }
        }

        // form the output line
        tvResult.text = num1.toString() + " " + oper + " " + num2 + " = " + result
    }
}