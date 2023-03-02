package com.example.roomdb.Adapter

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.roomdb.Activity.AdduserActivity
import com.example.roomdb.Database.DatabaseClass
import com.example.roomdb.Entity.User
import com.example.roomdb.R
import com.example.roomdb.globalVariables.GlobalVariables


class UserAdapter(userList: MutableList<User>) : RecyclerView.Adapter<UserHolder?>()
{
    var userList: MutableList<User>
    var db: DatabaseClass? = null
    private var mContext: Context? = null

    init
    {
        this.userList = userList
    }

    @NonNull
    override fun onCreateViewHolder(@NonNull parent: ViewGroup, i: Int): UserHolder {
        mContext = parent.getContext()
        db = Room.databaseBuilder(parent.getContext(),
            DatabaseClass::class.java, "myDatabase").allowMainThreadQueries().build()
        val v: View = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_adapter, parent, false)
        return UserHolder(v)
    }

    override fun onBindViewHolder(@NonNull userHolder: UserHolder, position: Int)
    {
        userHolder.name.setText(userList[position].name.toString())
        userHolder.email.setText(userList[position].email.toString())
        userHolder.itemView.setOnClickListener {

                var alert = AlertDialog.Builder(mContext)
                alert.setTitle("Select Operation?")
                alert.setPositiveButton("Update",{ dialogInterface: DialogInterface, i: Int ->


                        GlobalVariables.id=userList[position].id
                        GlobalVariables.name=userList[position].name
                        GlobalVariables.email=userList[position].email

                        GlobalVariables.updateFlag = "update"
                        var i = Intent(mContext,AdduserActivity::class.java)
                        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        mContext!!.startActivity(i)



                })
                alert.setNegativeButton("Delete",{ dialogInterface: DialogInterface, i: Int ->

                    deleteuser(userList.get(position).id)
                    userList.removeAt(position)
                    notifyItemRemoved(position)
                    notifyItemRangeChanged(position, userList.size)

                })
                alert.show()

        }

    }
    fun deleteuser(id:Int)
    {
        val user = User()
        user.id = id
        db!!.daoClass().deleteuser(user)
        Toast.makeText(mContext,"Deleted",Toast.LENGTH_LONG).show()
    }
    override fun getItemCount(): Int
    {
        return userList.size
    }

}
class UserHolder(@NonNull itemView: View) : RecyclerView.ViewHolder(itemView)
{
    val name: TextView
    val email: TextView

    init
    {
        name = itemView.findViewById<TextView>(R.id.name)
        email = itemView.findViewById<TextView>(R.id.email)
    }
}