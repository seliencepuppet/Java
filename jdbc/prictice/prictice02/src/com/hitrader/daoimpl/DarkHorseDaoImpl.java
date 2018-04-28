package com.hitrader.daoimpl;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.hitrader.dao.DarkHorseDao;
import com.hitrader.model.DarkHorse;

public class DarkHorseDaoImpl extends BaseDao implements DarkHorseDao{

	@Override
	public List<Map> selectDarkHorse() {
		String sql = "SELECT tnrs.id,ta.role,ta.id aid,tu.nick_name,tu.head,tn.national_name,tn.national_us_name,tn.national_tw_name,tn.national_by_name,tn.flag_img_src,tc.id commodity_id,tc.name, tnrs.strategy_id,tnrs.next_win_number,sd.DERIVE_CRSC FROM t_nextwin_rate_show tnrs INNER JOIN t_account ta on ta.id = tnrs.acount_id INNER JOIN t_user tu on ta.user_id = tu.id INNER JOIN t_national tn on tn.id = tu.national_id INNER JOIN t_commodity tc on tc.id = tnrs.commodity_id INNER JOIN t_s_user su ON su.USER_SPACEID = ta.id INNER JOIN t_s_derive sd ON sd.DERIVE_USER_ID = su.USER_ID AND sd.DERIVE_ITEM = tc.name WHERE tnrs.dark_horse = 1 AND tnrs.next_win_number > '0.50' AND tnrs.next_win_number < '0.70' AND tnrs.show_state = 0 AND ta.role=5 AND ta.stat=4 ORDER BY tnrs.next_win_number DESC limit 10;";
		try {
			List<Map> list = operDarkHorse(sql, null, null);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
