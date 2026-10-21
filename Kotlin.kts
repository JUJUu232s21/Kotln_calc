package semyon.android.studio.kotlin_calck
import android.content.res.Configuration
import android.os.Bundle
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import android.view.View
import android.os.Build
import androidx.core.content.ContextCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import android.widget.Toast
import android.window.SplashScreen
import androidx.activity.OnBackPressedCallback
import androidx.activity.addCallback
import androidx.core.view.WindowInsetsCompat
import net.objecthunter.exp4j.ExpressionBuilder
class MainActivity : AppCompatActivity() {
    private lateinit var getResult: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                finish()
                overridePendingTransition(0, 0)
            }
        }
        onBackPressedDispatcher.addCallback(this, callback)
        getResult = findViewById<EditText>(R.id.getResult)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        getResult.setText("0")
    }
    fun C (view: View) {
        getResult.setText("0")
    }
    fun proc(view: View) {
        val inputText = getResult.text.toString().trim()
        if (inputText.isEmpty() || inputText == "0") {
            return
        }
        getResult.setText(inputText + "%")
    }
    fun del (view: View) {
        if (getResult.text.toString().trim().equals("0")) {
            return
        }
        if (getResult.text.toString().trim().length == 1) {
            getResult.setText("0")
            return
        }
        val text = getResult.text.toString()
        getResult.setText(text.dropLast(1))
        getResult.setSelection(getResult.text.length)
    }
    fun o (view: View){
        val inputText = getResult.text.toString().trim()
        getResult.setText(inputText + "0")
    }
    fun point (view: View) {
        val inputText = getResult.text.toString().trim()
        if (inputText.endsWith(".") ||
            inputText.endsWith("%") ||
            inputText.endsWith("/") ||
            inputText.endsWith("*") ||
            inputText.endsWith("+") ||
            inputText.endsWith("-")) {
            return
        }
        getResult.setText(inputText + ".")
    }
    fun one (view: View) {
        if (getResult.text.toString().trim().equals("0")) {
            getResult.setText("")
        }
        val inputText = getResult.text.toString().trim()
        getResult.setText(inputText + "1")
    }
    fun two (view: View) {
        if (getResult.text.toString().trim().equals("0")) {
            getResult.setText("")
        }
        val inputText = getResult.text.toString().trim()
        getResult.setText(inputText + "2")
    }
    fun three (view: View){
        if (getResult.text.toString().trim().equals("0")) {
            getResult.setText("")
        }
        val inputText = getResult.text.toString().trim()
        getResult.setText(inputText + "3")
    }
    fun four (view: View) {
        if (getResult.text.toString().trim().equals("0")) {
            getResult.setText("")
        }
        val inputText = getResult.text.toString().trim()
        getResult.setText(inputText + "4")
    }
    fun five (view: View) {
        if (getResult.text.toString().trim().equals("0")) {
            getResult.setText("")
        }
        val inputText = getResult.text.toString().trim()
        getResult.setText(inputText + "5")
    }
    fun six (view: View) {
        if (getResult.text.toString().trim().equals("0")) {
            getResult.setText("")
        }
        val inputText = getResult.text.toString().trim()
        getResult.setText(inputText + "6")
    }
    fun seven (view: View) {
        if (getResult.text.toString().trim().equals("0")) {
            getResult.setText("")
        }
        val inputText = getResult.text.toString().trim()
        getResult.setText(inputText + "7")
    }
    fun eight (view: View) {
        if (getResult.text.toString().trim().equals("0")) {
            getResult.setText("")
        }
        val inputText = getResult.text.toString().trim()
        getResult.setText(inputText + "8")
    }
    fun nine (view: View) {
        if (getResult.text.toString().trim().equals("0")) {
            getResult.setText("")
        }
        val inputText = getResult.text.toString().trim()
        getResult.setText(inputText + "9")
    }
    fun delenie (view: View){
        val inpuText = getResult.text.toString().trim()
        if (inpuText.endsWith(".") ||
            inpuText.endsWith("%") ||
            inpuText.endsWith("/") ||
            inpuText.endsWith("*") ||
            inpuText.endsWith("+") ||
            inpuText.endsWith("-")){
            return
        }
        getResult.setText(inpuText + "/")
    }
    fun multip (view: View){
        val inpuText = getResult.text.toString().trim()
        if (inpuText.endsWith(".") ||
            inpuText.endsWith("%") ||
            inpuText.endsWith("/") ||
            inpuText.endsWith("*") ||
            inpuText.endsWith("+") ||
            inpuText.endsWith("-")) {
            return
        }
        getResult.setText(inpuText + "*")
    }
    fun minuse (view: View) {
        val inpuText = getResult.text.toString().trim()
        if (inpuText.endsWith(".") ||
            inpuText.endsWith("%") ||
            inpuText.endsWith("/") ||
            inpuText.endsWith("*") ||
            inpuText.endsWith("+") ||
            inpuText.endsWith("-")) {
            return
        }
        getResult.setText(inpuText + "-")
    }
    fun pluse (view: View) {
        val inpuText = getResult.text.toString().trim()
        if (inpuText.endsWith("+") ||
            inpuText.endsWith("-") ||
            inpuText.endsWith("*") ||
            inpuText.endsWith("/") ||
            inpuText.endsWith(".") ||
            inpuText.endsWith("%")) {
            return
        }
        getResult.setText(inpuText + "+")
    }
    fun resulte(view: View) {
        val inpuText = getResult.text.toString().trim()
        try {
            val expression = ExpressionBuilder(inpuText).build()
            val result = expression.evaluate()
            getResult.setText(result.toString())
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
        }
    }
    override fun onResume() {
        super.onResume()
        updateSystemBars()
    }
    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        window.decorView.post {
            updateSystemBars()
        }
    }
    private fun  updateSystemBars() {
        window.navigationBarColor = ContextCompat.getColor(this, R.color.gray)
        window.statusBarColor = ContextCompat.getColor(this, R.color.gray)
        WindowCompat.getInsetsController(window, window.decorView)?.apply {
            isAppearanceLightStatusBars = false
            isAppearanceLightNavigationBars = false
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            window.isNavigationBarContrastEnforced = false
        }
    }
}
