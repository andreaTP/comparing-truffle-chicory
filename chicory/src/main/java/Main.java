import com.dylibso.chicory.runtime.Module;
import com.dylibso.chicory.wasm.types.Value;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        var module = Module.builder(new File("wasm/add.wasm")).build();
        var instance = module.instantiate();
        var addFun = instance.export("add");

        var result = addFun.apply(Value.i32(40), Value.i32(2));

        var value = result[0].asInt();
        assert(value == 42);
        System.out.println("Result: " + value);
    }
}
