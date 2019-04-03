//package com.lfj.demo.component;
//
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@Component
//public class RedisPool implements InitializingBean {
//
//    @Value("${redis.cluster.nodes}")
//    private String nodes;
//
//    @Value("${redis.cluster.max-redirects}")
//    private String maxRedirects;
//
//    @Value("${redis.cluster.timeout}")
//    private String timeout;
//
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        try {
//            String[] ipPort = this.nodes.split(",");
//            GenericObjectPoolConfig config = new GenericObjectPoolConfig();
//            config.setMaxIdle(20);
//            config.setMaxTotal(2147483647);
//            config.setMaxWaitMillis(-1L);
//            config.setTestOnCreate(true);
//            config.setTestOnBorrow(true);
//            config.setTestOnReturn(true);
//            config.setTestWhileIdle(true);
//            Set<HostAndPort> jedisClusterNodes = new HashSet();
//
//            int t_timeout;
//            for(t_timeout = 0; t_timeout < ipPort.length; ++t_timeout) {
//                String[] ipPortArr = ipPort[t_timeout].split(":");
//                jedisClusterNodes.add(new HostAndPort(ipPortArr[0], Integer.parseInt(ipPortArr[1])));
//            }
//
//            t_timeout = StringUtils.isEmpty(this.timeout) ? 6000 : Integer.parseInt(this.timeout);
//            int t_maxRedirects = StringUtils.isEmpty(this.maxRedirects) ? 5 : Integer.parseInt(this.maxRedirects);
//            if (!StringUtil.isEmpty(this.password)) {
//                this.jedisMap.put(this.redisGroupName[0], new JedisCluster(jedisClusterNodes, t_timeout, t_timeout, t_maxRedirects, this.password, config));
//            } else {
//                this.jedisMap.put(this.redisGroupName[0], new JedisCluster(jedisClusterNodes, t_timeout, t_timeout, t_maxRedirects, config));
//            }
//
//            this.jedis = (JedisCluster)this.jedisMap.get("default");
//        } catch (Exception var6) {
//            var6.printStackTrace();
//        }
//    }
//}
