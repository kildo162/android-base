package com.kildo.core;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author kildo (khanhnd162@gmail.com)
 * @version 1.0.0
 * @created 3/26/21
 */
public class Engine {

    private static Engine engine = new Engine();
    private Map<Class, Component> components = new HashMap<Class, Component>();
    private ExecutorService executor = createExecutor();

    public static Engine instance() {
        return engine;
    }

    public void registerComponent(Component component) {
        components.put(component.getClass(), component);
    }

    public <T extends Component> T getComponent(Class<T> type) {
        return type.cast(components.get(type));
    }

    public void init() {

    }

    public void start() {
        for (Component c : components.values()) c.init();
        for (Component c : components.values()) c.start();
    }

    public void stop() {
        for (Component c : components.values()) c.stop();
    }

    private ExecutorService createExecutor() {
        int size = Runtime.getRuntime().availableProcessors();
        return Executors.newFixedThreadPool(size);
    }

    public void schedule(Operation operation) {
        executor.execute(operation);
    }

}
