package com.example.popup_menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {
    //deklarasi variabel dengan jenis data context
    Context mContext;

    //Deklarasi variabel dengan jenis data layout inflater
    LayoutInflater inflater;

    //deklarasi variabel dengan jenis data arraylist
    private ArrayList<ClassNama> arrayList;

    //membuat konstruktor listviewadapter
    public ListViewAdapter(Context context) {
        //memberi nilai mcontect dengan context
        mContext = mContext;

        //mengatur layoutinflater dari contect yang diberikan
        inflater = LayoutInflater.from(mContext);

        //Memberikan nilai arraylist dari class ClassNama
        this.arrayList = new ArrayList<ClassNama>();

        //menambahkan semua elemen ke arraylist
        this.arrayList.addAll(Home_Activity.classNamaArrayList);
    }
    //membuat class untuk mendeklarasikan tempat untuk meletakkan isi kedalam Listview
    public class ViewHolder {
        //mendeklarasikan variabel dengan jenis TextView
        TextView name;
    }

    //fungsi getCount () mengembalikan jumlah item yang akan ditampilkan dalam list
    @Override
    public int getCount(){
        //mengembalikan nilai berupa jumlah data dari array data
        return Home_Activity.classNamaArrayList.size();
    }
    //fungsi ini digunakan untuk mendapatkan data item yang terkait dengan posisi
    //tertentu dalam kumpulan data untuk mendapatkan data yang sesuai dari lokasi
    //tertentu dalam pengumpulan data item.

    @Override
    public Object getItem(int i) {
        //mengembalikan nilai berupa object dari array data
        return Home_Activity.classNamaArrayList.get(i);
    }
    @Override
    public long getItemId(int i) {
        return i;
    }

    //fungsi ini secara otomatis dipanggil ketika tampilan item list siap untuk
    //ditampilkan
    @Override
    public View getView (int i, View view, ViewGroup viewGroup){
        //deklarasi variable dengan jenis data Viewholder
        final ViewHolder holder;

        //membuat kondisi apakah view null atau tidak
        if (view == null) {

            //membuat objek view holder
            holder = new ViewHolder();

            //mengatur layout untuk menampilkan item
            view = inflater.inflate(R.layout.item_listview, null);

            //set id untuk textview
            holder.name = (TextView) view.findViewById(R.id.tvnama_item);

            //menyimpan data dalam tampilan tanpa menggunakan struktur data lain.
            view.setTag((holder));
        } else {
            //mengatur holder untuk mengembalikan niai dari view tag.
            holder = (ViewHolder) view.getTag();
        }
        //set item ke TextViews
        holder.name.setText(Home_Activity.classNamaArrayList.get(i).getNama());

        //mengembalikan nilai ke variabel view
        return view;
    }
}
