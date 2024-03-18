import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Source;
import org.graalvm.polyglot.io.ByteSequence;

import java.io.FileInputStream;

public class Main {

    public static void main(String[] args) throws Exception {
        var binary = new FileInputStream("wasm/add.wasm").readAllBytes();

        var contextBuilder = Context.newBuilder("wasm");
        var sourceBuilder = Source.newBuilder("wasm", ByteSequence.create(binary), "example");

        var source = sourceBuilder.build();
        Context context = contextBuilder.build();

        context.eval(source);

        var addFun = context.getBindings("wasm").getMember("main").getMember("add");
        var result = addFun.execute(40, 2);

        assert(result.asInt() == 42);

        System.out.println("Result: " + result.asInt());
    }

}
