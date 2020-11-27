import KeyGenerate.*;
import org.fisco.bcos.asset.contract.Test;
import org.fisco.bcos.sdk.BcosSDK;
import org.fisco.bcos.sdk.client.Client;
import org.fisco.bcos.sdk.crypto.CryptoSuite;
import org.fisco.bcos.sdk.crypto.keypair.CryptoKeyPair;
import org.fisco.bcos.sdk.transaction.codec.decode.TransactionDecoderInterface;
import org.fisco.bcos.sdk.transaction.codec.decode.TransactionDecoderService;
import org.fisco.bcos.sdk.transaction.model.exception.ContractException;

import java.math.BigInteger;
import java.util.List;
import java.util.Scanner;

public class test1 {


    public static void main(String args[]) throws ContractException {

        //程序开始时间
       // long startTime=System.currentTimeMillis();

        //Parameter.main();

        String configFile = "config-example.toml";
        // 初始化SDK
        BcosSDK sdk =  BcosSDK.build(configFile);
        // 发送群组ID1
        Client client = sdk.getClient(Integer.valueOf(1));
        // 获取当前群组对应的密码学接口
        CryptoSuite cryptoSuite = client.getCryptoSuite();
        // 构造TransactionDecoderService实例，传入是否密钥类型参数。
        TransactionDecoderInterface decoder = new TransactionDecoderService(cryptoSuite);

        CryptoKeyPair cryptoKeyPair = client.getCryptoSuite().getCryptoKeyPair();//这是干啥的？？？
        Test kk=Test.deploy(client, cryptoKeyPair);
        kk.register("a");
        kk.pkin("a", BigInteger.valueOf(1));
        kk.pkout(1);
        List<BigInteger> a = null;
        a.add(BigInteger.valueOf(1));
        a.add(BigInteger.valueOf(2));
        kk.cipherin("a",a,a);
        kk.cipherout(BigInteger.valueOf(1));



        //String configFile = SDKBean.class.getClassLoader().getResource("config.toml").getPath();
        //BcosSDK sdk = BcosSDK.build(configFile);
        //Client client = sdk.getClient(1);
        //HelloWorld helloWorld = HelloWorld.deploy(client, cryptoKeyPair);
        //System.out.println(helloWorld.get());


        //long endTime=System.currentTimeMillis();
        //System.out.println("Program running time="+(endTime-startTime)+"ms");

    }
}
