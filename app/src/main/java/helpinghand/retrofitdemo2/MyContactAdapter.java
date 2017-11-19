package helpinghand.retrofitdemo2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Rasil10 on 2017-11-16.
 */

public class MyContactAdapter extends RecyclerView.Adapter<MyContactAdapter.ContactViewHolder> {
    List<Contact> contactList;
    Context context;
    List<PostalCode.PostalData> postalDataList;

    private static int currentPosition = 0;

//    public MyContactAdapter(Context context,List<Contact> contactList) {
//        this.context = context;
//        this.contactList = contactList;
//    }
//
//
//
//    @Override
//    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
//        return new ContactViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(ContactViewHolder holder, final int position) {
//        Contact contact=contactList.get(position);
//
//        holder.nameTextView.setText(contact.getName());
//        holder.emailTextView.setText(contact.getPhone().getMobile());
//        Picasso.with(context).load(contact.getProfilePic()).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(holder.imageImageView);
//    }
//
//    @Override
//    public int getItemCount() {
//        return contactList.size();
//    }
//
//
//    class ContactViewHolder extends RecyclerView.ViewHolder{
//        TextView nameTextView,emailTextView;
//        ImageView imageImageView;
//        LinearLayout linearLayout;
//
//        public ContactViewHolder(View itemView) {
//            super(itemView);
//
//            nameTextView=(TextView)itemView.findViewById(R.id.textViewName);
//            emailTextView=(TextView)itemView.findViewById(R.id.textViewEmail);
//
//            imageImageView=(ImageView)itemView.findViewById(R.id.imageView);
//        }
//    }


    public MyContactAdapter(Context context, List<PostalCode.PostalData> postalDataList) {
        this.context = context;
        this.postalDataList = postalDataList;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, final int position) {
//        Contact contact=contactList.get(position);
//
//        holder.nameTextView.setText(contact.getName());
//        holder.emailTextView.setText(contact.getPhone().getMobile());
//        Picasso.with(context).load(contact.getProfilePic()).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(holder.imageImageView);


        PostalCode.PostalData postalData=postalDataList.get(position);
        holder.nameTextView.setText(String.valueOf(postalData.getId()));
        holder.emailTextView.setText(postalData.getPostcode());

//        Picasso.with(context).load(contact.getProfilePic()).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(holder.imageImageView);

    }

    @Override
    public int getItemCount() {
        return postalDataList.size();
    }


    class ContactViewHolder extends RecyclerView.ViewHolder{
        TextView nameTextView,emailTextView;
        ImageView imageImageView;
        LinearLayout linearLayout;

        public ContactViewHolder(View itemView) {
            super(itemView);

            nameTextView=(TextView)itemView.findViewById(R.id.textViewName);
            emailTextView=(TextView)itemView.findViewById(R.id.textViewEmail);

//            imageImageView=(ImageView)itemView.findViewById(R.id.imageView);
        }
    }
}
