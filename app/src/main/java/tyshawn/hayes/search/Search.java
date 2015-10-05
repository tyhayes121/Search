package tyshawn.hayes.search;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
/**import android.view.Menu;
import android.view.MenuItem;


import android.os.Bundle;*/

import android.text.Editable;

import android.text.TextWatcher;

import android.widget.ArrayAdapter;

import android.widget.EditText;

import android.widget.ListView;

import java.util.ArrayList;

import java.util.Arrays;

public class Search extends AppCompatActivity {


        String[] items;

        ArrayList<String> listItems;

        ArrayAdapter<String> adapter;

        ListView listView;

        EditText editText;

        protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_search);

            listView=(ListView)findViewById(R.id.listView);

            editText=(EditText)findViewById(R.id.txtsearch);

            initList();

            editText.addTextChangedListener(new TextWatcher() {

                @Override

                public void beforeTextChanged(CharSequence s, int start, int count, int
                        after) {



                }



                @Override

                public void onTextChanged(CharSequence s, int start, int before, int
                        count) {

                    if(s.toString().equals("")){



                        initList();

                    }

                    else{

                        

                        searchItem(s.toString());

                    }

                }



                @Override

                public void afterTextChanged(Editable s) {



                }

            });

        }



        public void searchItem(String textToSearch){

            for(String item:items){

                if(!item.contains(textToSearch)){

                    listItems.remove(item);

                }

            }

            adapter.notifyDataSetChanged();

        }

        public void initList(){

            items=new String[]{"Math","Science","History","CSCI"};

            listItems=new ArrayList<>(Arrays.asList(items));

            adapter=new ArrayAdapter<>(this,
                    R.layout.list_item, R.id.txtitem, listItems); // went from <String> to <>

            listView.setAdapter(adapter);

        }

    }


