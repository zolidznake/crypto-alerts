# CryptoStocks.WS
crypto-alerts Project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```


You can then execute your native executable with: `./target/crypto-alerts-1.0.0-SNAPSHOT-runner`

## Related guides

Check CoinMarketCap API Documentation
>https://coinmarketcap.com/api/

## Provided implementations

    @GET( "v1/cryptocurrency/listings/latest")
    Call<Latest> getLatestList();

    @GET("v1/cryptocurrency/map")
    Call<AllTokens> getAllTokens();


##Have some fun while developing ;)

>Youtube: https://www.youtube.com/watch?v=ySLc8gZ3oEc

![Image of Yaktocat](https://octodex.github.com/images/daftpunktocat-thomas.gif)


