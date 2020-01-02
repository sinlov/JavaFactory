# Notes

This is java Factory

- java version 1.7
- gradle version 2.10
- jdk must be support PKCS7Padding RSA-256 

# Module

## TestForm

use to same java code test for cook

## Utils

java Utils

- date
- security
- math
- IO
- enum
- reflect

# Error

## Cannot find any provider supporting AES/CBC/PKCS7Padding

### depends

```groovy
dependencies {
    implementation security_depend.org_bouncycastle_bcprov_jdk15on
    implementation security_depend.org_bouncycastle_bcpg_jdk15on
}
```

### add pkg at jdk

because jdk has not PKCS7Padding, has PKCS5Padding

just use [BouncyCastle](https://downloads.bouncycastle.org/java/bcprov-jdk15on-154.jar))

```java
// can not found org.bouncycastle.jce.provider
Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
// Cipher is not thread safe
Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
```

download at [http://www.bouncycastle.org/latest_releases.html](http://www.bouncycastle.org/latest_releases.html)

- `bcprov-ext-jdk*.jar` to folder `$JAVA_HOME/jre/lib/ext`
- this use [bcprov-ext-jdk15on-164.jar](jar/bcprov-ext-jdk15on-164.jar)

add info at `$JAVA_HOME/jre/lib/security/java.security`
- find out `cat $JAVA_HOME/jre/lib/security/java.security | grep security.provider`
- after `security.provider.10=apple.security.AppleProvider`
```
security.provider.11=org.bouncycastle.jce.provider.BouncyCastleProvider
```

## Illegal key size or default parameters

```sh
java.security.InvalidKeyException: Illegal key size or default parameters...
```

need file `${java_home}/jre/lib/security`

[jdk8-jce](http://www.oracle.com/technetwork/java/javase/downloads/jce8-download-2133166.html)
[jdk7-jce](http://www.oracle.com/technetwork/java/javase/downloads/jce-7-download-432124.html)
[jdk6-jce](http://www.oracle.com/technetwork/java/javase/downloads/jce-6-download-429243.html)

replace `local_policy.jar` and `US_export_policy.jar` below `${java_home}/jre/lib/security/`