package com.anji.www.adapter;

import java.util.ArrayList;
import java.util.List;

import com.anji.www.R;
import com.anji.www.activity.MainActivity;
import com.anji.www.adapter.SwitchListAdapter.ItemViewHolder;
import com.anji.www.constants.MyConstants;
import com.anji.www.entry.DeviceInfo;
import com.anji.www.entry.GroupInfo;
import com.anji.www.service.UdpService;
import com.anji.www.util.LogUtil;
import com.anji.www.util.Utils;
import com.ipc.sdk.DevInfo;
import com.remote.util.IPCameraInfo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class CameraGridViewAdapter extends BaseAdapter
{
	private List<IPCameraInfo> deviceList;
	private Context myContext;
	private final static String TAG = "GroupListAdapter";

	public CameraGridViewAdapter(Context myContext, List<IPCameraInfo> deviceList)
	{
		this.myContext = myContext;
		this.deviceList = deviceList;
	}

	public void setList(List<IPCameraInfo> list)
	{
		this.deviceList = list;
		notifyDataSetChanged();
	}

	@Override
	public int getCount()
	{
		// TODO Auto-generated method stub
		return (deviceList == null) ? 1 : deviceList.size() + 1;
	}

	@Override
	public Object getItem(int position)
	{
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position)
	{
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		ItemViewHolder listItemView = null;
		if (convertView == null)
		{
			listItemView = new ItemViewHolder();
			convertView = LayoutInflater.from(myContext).inflate(
					R.layout.item_add_list, null);
			// 获得控件对象
			listItemView.tv_group_name = (TextView) convertView
					.findViewById(R.id.tv_group_name);
			listItemView.img_group_head = (ImageView) convertView
					.findViewById(R.id.img_group_head);
			// 设置空间集到convertView
			convertView.setTag(listItemView);
		}
		else
		{
			listItemView = (ItemViewHolder) convertView.getTag();
		}
		if (deviceList != null)
		{
			if (position >= 0 && position < deviceList.size())
			{

				final IPCameraInfo item = deviceList.get(position);
				if (item != null)
				{
					// 普通灯具
					listItemView.tv_group_name.setText(item.devName);
					listItemView.img_group_head
							.setImageResource(R.drawable.icon_shexiangkuang_1);
				}
			}
			else
			{
				listItemView.img_group_head
						.setImageResource(R.drawable.add_button_selector);
				listItemView.tv_group_name.setText("");
			}
		}
		return convertView;
	}

	class ItemViewHolder
	{
		ImageView img_group_head; // 分组头像
		TextView tv_group_name; // 分组名称
	}
}
