package provider;

import java.util.HashMap;
import java.util.Map;

/**
 * 之前这里使用Map简单实现的
 * 存放服务接口名与服务端对应的实现类
 * 服务启动时要暴露其相关的实现类0
 * 根据request中的interface调用服务端中相关实现类
 */
public class ServiceProvider {
    /**
     * 一个实现类可能实现多个接口
     */
    private Map<String, Object> interfaceProvider;

    public ServiceProvider(){
        this.interfaceProvider = new HashMap<>();
    }

    public void provideServiceInterface(Object service){
        //得到service的名称
        String serviceName = service.getClass().getName();
        //得到service所在的interface->实现了多个接口
        Class<?>[] interfaces = service.getClass().getInterfaces();
        //多个接口
        for(Class clazz : interfaces){
            interfaceProvider.put(clazz.getName(),service);
        }

    }

    public Object getService(String interfaceName){
        return interfaceProvider.get(interfaceName);
    }
}