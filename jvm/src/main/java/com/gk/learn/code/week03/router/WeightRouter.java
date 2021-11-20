package com.gk.learn.code.week03.router;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class WeightRouter implements HttpEndpointRouter {

	@Override
	public String route(List<String> urls) {
		// 读取配置文件
		Properties properties = new Properties();
		try {
			InputStream in = WeightRouter.class.getClassLoader().getResource("application.properties").openStream();
			properties.load(in);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		String weightConfig = properties.getProperty("server.weight");
		int m = 0;
		int totalWeight = 0;
		Map<Integer, String> map = new HashMap<>();
		for (String server : weightConfig.split(",")) {
			String[] serverInfo = server.split("_");
			Integer weight = Integer.valueOf(serverInfo[1]);
			totalWeight += weight;
			for (Integer i = m; i < totalWeight; i++) {
				m++;
				map.put(i, serverInfo[0]);
			}
		}
		// 生成随机数
		return map.get(new Random().nextInt(totalWeight));
	}

}
