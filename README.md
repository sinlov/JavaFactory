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

because jdk has not PKCS7Padding, has PKCS5Padding

just use [BouncyCastle](https://downloads.bouncycastle.org/java/bcprov-jdk15on-154.jar))

```java

Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
// Cipher is not thread safe
Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");

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