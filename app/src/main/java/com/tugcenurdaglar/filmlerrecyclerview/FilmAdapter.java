package com.tugcenurdaglar.filmlerrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.tugcenurdaglar.detaylirecyclerviewkullanimi.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.CardViewTasarimNesnleriniTutucu>{
    //context oluşturup oluşturmamak da özgürsün olur da androidle ilgili bi şey
    //kullanmak istersek mesela Toast Mesaj gibi bu gibi şeyleri olur da kullanmak
    //istersek.
    private Context mContext;

    //şimdi veri kümemi tanımlayayım

    private List<Filmler> filmlerList;

    //Filmler sınıfının nesnelerini tutacağı için türünü filmler yaptım
    //türünü <> içine yazarız


    public FilmAdapter(Context mContext, List<Filmler> filmlerList) {
        this.mContext = mContext;
        this.filmlerList = filmlerList;
    }//generate constructor

    @NonNull
    @Override //bu method tasarımımızı temsil ediyor bu method oluşmazsa tasarımımız çalışmaz
    public CardViewTasarimNesnleriniTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       // bu method tamamlnamış görsel nesnelerin
        // hangi tasarımdan alınacağı bilgisini istiyor
        //dolayısıyla card_film_tasarim i buraya bağlamalıyım

        View itemView = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.card_film_tasarim,parent,false);


        //inflate ile tasarımlarımızı yükleriz
        //parent( bağlı olduğu root olarak yazıldı)

        //bu itemView ı aşağıdaki itemView a göndermemm gerekiyor,
        // aşağıya göndermek istiyorsam yukarıdan bir nesne oluşturmam lazım
        //aşağı dediğim yer CardViewTasarimNesnleriniTutucu sınıfı
//        return null; bunu siliyoruz
        return  new CardViewTasarimNesnleriniTutucu(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewTasarimNesnleriniTutucu holder, int position) {
        final Filmler film = filmlerList.get(position);

        holder.textViewFilmBaslik.setText(film.getFilm_ad());
        holder.textViewFilmFiyat.setText(film.getFilm_fiyat()+" TL");

        holder.imageViewFilmResim.setImageResource(mContext.
                getResources().getIdentifier(
                film.getFilm_resim_ad(),
                "drawable", mContext.getPackageName()
        ));

        holder.buttonSepeteEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,film.getFilm_ad()+" sepete eklendi", Toast.LENGTH_SHORT).show();


            }
        });

    }

    @Override
    public int getItemCount() { //kaç tane card gösterileceğini soruyor
//        return 0;
        return filmlerList.size(); //filmlerList boyutu kadar card gösterilsin
    }

    //card tasarımının üzerindeki görsel nesneleri sembolize edecek bir sınıf oluşturalım

    public class CardViewTasarimNesnleriniTutucu extends RecyclerView.ViewHolder{
        public ImageView imageViewFilmResim;
        public TextView textViewFilmBaslik;
        public TextView textViewFilmFiyat;
        public Button buttonSepeteEkle;

        //şimdi Constructor oluşturalım


        public CardViewTasarimNesnleriniTutucu(@NonNull View itemView) {
            super(itemView);
            //view kullnamasının sebebi bizden tasarımımızı istemesi

            imageViewFilmResim= itemView.findViewById(R.id.imageViewFilmResim);
            textViewFilmBaslik = itemView.findViewById(R.id.textViewFilmBaslik);
            textViewFilmFiyat = itemView.findViewById(R.id.textViewFilmFiyat);
            buttonSepeteEkle = itemView.findViewById(R.id.buttonSepeteEkle);

        }
        //CardViewTasarimNesnleriniTutucu sınıfını FilmAdapter sınıfına
        // bağlamak için
        //public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.CardViewTasarimNesnleriniTutucu>{
        //şeklinde tamamlayalım altı çizili oluşunu gidermek için kırmızı lambaya tıklayıp
        //implements methods diyelim ve metodlar kendiliğinden otomatik olarak oluşsun


    }
}

