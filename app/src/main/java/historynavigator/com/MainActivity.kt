package historynavigator.com

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val textView: TextInputLayout=findViewById(R.id.Result)
        val clear: Button=findViewById(R.id.Clear)
        val age: EditText=findViewById(R.id.Age)
        val generate: Button=findViewById(R.id.GenerateHistory)


        generate.setOnClickListener {
            val ageString = age.text.toString()
            if (ageString.isNotEmpty()) {
                if (!ageString.contains(".")) {
                    val age = ageString.toIntOrNull()
                    if (age != null && age in 15..100) {
                        var message: String = ""
                        when {
                            age >= 15 && age <= 20 -> message =
                                "Joan of Arc: Died at age 19. A peasant girl turned military leader, Joan played a crucial role in the Hundred Years' War between England and France."
                            age >= 20 && age <= 30 -> message =
                                "Pocahontas: Died at age 20. The daughter of Chief Powhatan, played a crucial role in early English colonization in Virginia. She is famous for reportedly saving the life of Captain John Smith and assisting English settlers."
                            age >= 30 && age <= 35 -> message =
                                "Alexander the Great: Died at age 32. A Macedonian king and military conqueror, Alexander created one of the largest empires in history, stretching from Greece to Egypt and India. "
                            age >= 35 && age <= 40 -> message =
                                "Martin Luther King Jr.: Died at age 39. A leader in the American civil rights movement, King advocated for racial equality through nonviolent protests and powerful speeches."
                            age >= 50 && age <= 60 -> message =
                                "William Shakespeare: Died at age 52. Widely regarded as the greatest playwright in English literature."
                            age >= 60 && age <= 66 -> message =
                                "Marie Curie: Died at age 66. A pioneering physicist and chemist, Curie conducted groundbreaking research on radioactivity. "
                            age >= 67 && age <= 70 -> message =
                                "Leonardo da Vinci: Died at age 67. A Renaissance polymath, da Vinci excelled in art, science, and engineering.His paintings, including the iconic Mona Lisa and The Last Supper, showcase his artistic genius, while his notebooks reveal groundbreaking scientific observations and inventions."
                            age >= 70 && age <= 80 -> message =
                                "Mahatma Gandhi: Died at age 78. A key figure in India's fight for independence, Gandhi advocated for nonviolent civil disobedience.Known as the Mahatma or Great Soul, he inspired movements for civil rights and freedom across the world."
                            age >= 90 && age <= 95 -> message =
                                "Winston Churchill:  Died at age 90. A British statesman and Prime Minister during World War II, Churchill's leadership and eloquence rallied the British people against Nazi Germany."
                            age >= 95 && age <= 100 -> message =
                                "Nelson Mandela: Died at age 95. An anti-apartheid revolutionary, Mandela became the first black President of South Africa. His efforts to dismantle the apartheid system and promote reconciliation earned him global admiration and the Nobel Peace Prize."
                            else -> message = "No historical figure found for entered age"
                        }
                        textView.editText?.setText(message)
                    } else {
                        showToast("Please enter an age between 15 and 100.")
                    }
                } else {
                    showToast("Please enter a whole number age,")
                }
            } else {
                showToast("Please enter your age.")
            }
        }
        clear.setOnClickListener {
            age.text.clear()
            textView.editText?.setText("")
        }
    }


    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}