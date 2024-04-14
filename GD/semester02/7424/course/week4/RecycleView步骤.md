# RecycleView步骤

### 1， activity_main里创建 RecycleView布局，并设置ID

```java
<!--  step 1: -->
    <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/r_view"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        />

```

### 2, 创建RecycleView里的单个项目的布局

```java
<!--  step 2: -->
<TextView
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="50dp"
    android:layout_margin="5dp"
    android:text="Country Name"
    android:textSize="25sp"
    android:background="#ffbb33"
    android:textColor="#d81b60"
    android:id="@+id/item_name"
    />
```

3. ### 创建适配，泛型传入RecyclerView.ViewHolder类；

```java
// step 3
// 创建适配器类继承自RecyclerView.Adapter，泛型传入RecyclerView.ViewHolder类
public class RVAdapter extends RecyclerView.Adapter <RVHolder>{
    String data[];
    // 初始化数据
    public RVAdapter(String[] data) {
        this.data = data;
    }

    // 重写此方法，用于常见ViewHolder类的实例对象，接受rv_item,返回一个ViewHolder对象
    @NonNull
    @Override
    public RVHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 创建viewHolder,返回每一项的布局
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view =inflater.inflate(R.layout.rv_item,parent,false);
        return new RVHolder(view);
    }
    // 对没给item进行赋值,
    @Override
    public void onBindViewHolder(@NonNull RVHolder holder, int position) {
        // 将数据和控件绑定
        holder.tv.setText(data[position]);

    }

    // 返回总共有多少个item
    @Override
    public int getItemCount() {
        return data.length;
    }
}
```

### 4. 创建内部类即RecyclerView.ViewHolder类的子类，用于绑定TextView控件

```java
// step 4: 创建内部类即RecyclerView.ViewHolder类的子类，用于绑定TextView控件
public class RVHolder extends RecyclerView.ViewHolder {
    TextView tv;
    public RVHolder(@NonNull View itemView) {
        super(itemView);
        tv=itemView.findViewById(R.id.item_name);
    }
}
```

### 5，MainActivity中，初始化数据，设置LayoutManager和适配器

```java
public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // step 5:在Activity中获取RecyclerView控件然后进行设置LayoutManger以及Adapter即可
        recyclerView=findViewById(R.id.r_view);

        // 添加数据，初始化数据
        String []data = {"New Zealand","Australia","USA","China","India","Pakistan","UAE","UK","Canada","South Africa", "Japan","Fiji"};
        // 实例化适配器
        RVAdapter adapter = new RVAdapter(data);

        //设置LayoutManager
        recyclerView.setLayoutManager(
                new LinearLayoutManager(this));

        //设置适配器
        recyclerView.setAdapter(adapter);
    }
}
```





