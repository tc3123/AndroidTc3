package tc3.android.ui;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import tc3.android.R;
import tc3.android.common.BaseActivity;

/**
 * RecyclerView演示
 *  方法
 *  onMeasure确定view大小
 *  onLayout 分配子View大小和位置
 *
 *
 *  内部类
 *  Adapter
 *  ViewHolder
 *  LayoutManager 负责测量、布局RecyclerView、回收不可见的item view
 *  LayoutParams
 *  Recycler 管理 scrapped or detached 的item view以便复用
 *      属性
 *      mAttachedScrap、mChangedScrap 一级缓存
 *      mCachedViews  二级缓存
 *      mViewCacheExtension 三级缓存
 *      mRecyclerPool 四级缓存
 *      方法
 *      getViewForPosition 获取某位置的View,被LayoutManager调用
 *          tryGetViewHolderForPositionByDeadline 获取ViewHolder
 *              0 根据位置找mChangedScrap
 *              1 根据位置找mAttachedScrap，ChildHelper的mHiddenViews，mCachedViews
 *              2 mAdapter如果有StableId，根据id找mAttachedScrap， mCachedViews
 *              3 根据位置和type找mViewCacheExtension
 *              4 根据type找mRecyclerPool
 *              5 mAdapter.createViewHolder(RecyclerView.this, type)创建ViewHolder
 *                tryBindViewHolderByDeadline->mAdapter.bindViewHolder(holder, offsetPosition); ViewHolder绑定Adapter数据
 *                holder.itemView设置LayoutParams
 *
 *      recycleView(@NonNull View view) 回收View到缓存
 *          recycleViewHolderInternal(ViewHolder holder) 添加holder到mCachedViews，如果没有mCachedViews添加到mRecyclerPool
 *
 *      scrapView(View view) 添加holder到mAttachedScrap或mChangedScrap，
 *          如果ViewHolder设置FLAG_REMOVED 或 FLAG_INVALID 或FLAG_UPDATE 或没有动画重用 添加holder到mAttachedScrap
 *          否则添加holder到mChangedScrap
 *
 *  RecycledViewPool  用于多RecyclerView共享View， RecyclerView.setRecycledViewPool(RecycledViewPool)设置，RecyclerView默认提供一个
 *      ScrapData(ViewHolder列表,列表最大容量)
 *      RecycledViewPool.mScrap (ViewHolder类型: ScrapData)
 *      RecycledViewPool管理ViewHolder池
 *  ViewCacheExtension 抽象工具类，一层开发者提供的View缓存，RecyclerView.setViewCacheExtension设置
 * State
 * AdapterHelper
 * ChildHelper
 */
public class RecyclerViewActivity extends BaseActivity {

    @BindView(R.id.cvMain)
    RecyclerView cvMain;
    private List<Map<String,String>> list = new ArrayList<>();
    private RecyclerView.LayoutManager layoutManager;
    private Adpater1 adapter;

    @Override
    protected int getLayout() {
        return R.layout.activity_recyclerview;
    }

    @Override
    protected void initView() {
        layoutManager = new LinearLayoutManager(this);
        cvMain.setLayoutManager(layoutManager);

        list = new ArrayList<>();
        for (int i = 0;i<10;i++){
            HashMap<String,String> map = new HashMap<>();
            map.put("name","cc");
            map.put("age","13");
            map.put("index",i+"");
            list.add(map);
        }
        adapter = new Adpater1(list);
        cvMain.setAdapter(adapter);
    }

    @Override
    protected void initEvent() {

    }
}
