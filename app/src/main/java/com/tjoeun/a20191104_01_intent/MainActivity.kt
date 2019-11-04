package com.tjoeun.a20191104_01_intent

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_edit_user_info.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val REQ_CODE_FOR_NAME = 1000
    val REQ_CODE_FOR_PHONE = 1001

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        phoneNumInputBtn.setOnClickListener {
            var intent = Intent(this, EditPhoneNumActivity::class.java)
            startActivityForResult(intent, REQ_CODE_FOR_PHONE)
        }

        nameInputBtn.setOnClickListener {

            var intent = Intent(this, EditUserInfoActivity::class.java)

//            if (nameEdt.text.toString() != "이름 입력 필요") {
//                intent.putExtra("userName", nameEdt.text.toString())
//            }

            startActivityForResult(intent, REQ_CODE_FOR_NAME)

        }


        phoneDialBtn.setOnClickListener {
            var uri = Uri.parse("tel:01048765358") // 띄어쓰기 하면 안됨.
            var intent = Intent(Intent.ACTION_DIAL, uri)
            startActivity(intent)
        }


        phoneCallBtn.setOnClickListener {
 //           var uri = Uri.parse("tel:01048765358")
 //           var intent = Intent(Intent.ACTION_CALL, uri)
  //          startActivity(intent)
        }

        smsBtn.setOnClickListener {
            var uri = Uri.parse("smsto:01048765358")
            var intent = Intent(Intent.ACTION_SENDTO, uri)
            intent.putExtra("sms_body", "우리가 만든 앱입니다.")
            startActivity(intent)
        }



    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQ_CODE_FOR_NAME) {
            if (resultCode == Activity.RESULT_OK) {

                var inputNameData = data?.getStringExtra("inputName")?.toLowerCase()

                if (inputNameData != null) {

                }

                inputNameData?.let {

                    nameTxt.text = it


                    var myName:String? = null

                }

            }
        }
        else if (requestCode == REQ_CODE_FOR_PHONE) {
            if (resultCode == Activity.RESULT_OK) {
                var phoneNumStr = data?.getStringExtra("inputPhoneNum")

                phoneNumStr?.let {
                    phoneNumTxt.text = phoneNumStr
                }
            }
        }

    }

}







