package com.example.firebasecrudapp

import android.app.AlertDialog
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.FirebaseDatabase
import com.orhanobut.dialogplus.DialogPlus
import com.orhanobut.dialogplus.ViewHolder

class MyAdapter(options: FirebaseRecyclerOptions<Model>) : FirebaseRecyclerAdapter<Model, myviewholder>(options)
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myviewholder
    {
        val view: View = LayoutInflater.from(parent.getContext()).inflate(R.layout.design, parent, false)
        return myviewholder(view)
    }

    override fun onBindViewHolder(holder: myviewholder, position: Int, model: Model)
    {
        holder.name.setText(model.name)
        holder.email.setText(model.email)
        holder.pass.setText(model.password)

        holder.edit.setOnClickListener {

            val dialogPlus = DialogPlus.newDialog(holder.edit.context)
                .setContentHolder(ViewHolder(R.layout.dialogcontent))
                .setExpanded(true, 1100)
                .create()

            val myview = dialogPlus.holderView
            val name = myview.findViewById<EditText>(R.id.uname)
            val pass = myview.findViewById<EditText>(R.id.ucourse)
            val email = myview.findViewById<EditText>(R.id.uemail)
            val submit = myview.findViewById<Button>(R.id.usubmit)


            name.setText(model.name)
            pass.setText(model.password)
            email.setText(model.email)



            dialogPlus.show()

            submit.setOnClickListener {

                val map: MutableMap<String, Any> = HashMap()
                map["name"] = name.text.toString()
                map["email"] = email.text.toString()
                map["password"] = pass.text.toString()
                FirebaseDatabase.getInstance().getReference().child("tops")
                    .child(getRef(position).key!!).updateChildren(map)
                    .addOnSuccessListener {

                        Toast.makeText(holder.edit.context,"Updated",Toast.LENGTH_LONG).show()
                    }
                    .addOnFailureListener{


                        Toast.makeText(holder.edit.context,"Error",Toast.LENGTH_LONG).show()
                    }
            }


        }
        holder.delete.setOnClickListener {

            var alert = AlertDialog.Builder(holder.delete.context)
            alert.setTitle("DELETE?")
            alert.setPositiveButton("YES",{ dialogInterface: DialogInterface, i: Int ->

                FirebaseDatabase.getInstance().getReference().child("tops")
                    .child(getRef(position).getKey()!!)
                    .removeValue()

                notifyItemRangeChanged(position,0)


            })
            alert.setNegativeButton("No",{ dialogInterface: DialogInterface, i: Int ->

                dialogInterface.cancel()


            })
            alert.show()

        }
    }

}
class myviewholder(@NonNull itemView: View) : RecyclerView.ViewHolder(itemView) {
    var name: TextView
    var pass: TextView
    var email: TextView
    var edit: ImageView
    var delete: ImageView

    init
    {

        name = itemView.findViewById(R.id.txt1)
        email = itemView.findViewById(R.id.txt2)
        pass = itemView.findViewById(R.id.txt3)
        edit = itemView.findViewById(R.id.edit)
        delete = itemView.findViewById(R.id.delete)

    }
}