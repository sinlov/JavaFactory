package com.sinlov.my.test;

/**
 * <pre>
 *     sinlov
 *
 *     /\__/\
 *    /`    '\
 *  ≈≈≈ 0  0 ≈≈≈ Hello world!
 *    \  --  /
 *   /        \
 *  /          \
 * |            |
 *  \  ||  ||  /
 *   \_oo__oo_/≡≡≡≡≡≡≡≡o
 *
 * </pre>
 * Created by sinlov on 16/12/27.
 */
public class StringEscapeUtils {

//    public static final CharSequenceTranslator UNESCAPE_JAVA =
//            new AggregateTranslator(
//                    new OctalUnescaper(),     // .between('\1', '\377'),
//                    new UnicodeUnescaper(),
//                    new LookupTranslator(EntityArrays.JAVA_CTRL_CHARS_UNESCAPE()),
//                    new LookupTranslator(
//                            new String[][] {
//                                    {"\\\\", "\\"},
//                                    {"\\\"", "\""},
//                                    {"\\'", "'"},
//                                    {"\\", ""}
//                            })
//            );
//
//    public static final CharSequenceTranslator ESCAPE_JSON =
//            new AggregateTranslator(
//                    new LookupTranslator(
//                            new String[][] {
//                                    {"\"", "\\\""},
//                                    {"\\", "\\\\"},
//                                    {"/", "\\/"}
//                            }),
//                    new LookupTranslator(EntityArrays.JAVA_CTRL_CHARS_ESCAPE()),
//                    JavaUnicodeEscaper.outsideOf(32, 0x7f)
//            );
//
//    public static final String unescapeJava(final String input) {
//        return UNESCAPE_JAVA.translate(input);
//    }
//
//    public static final String escapeJson(final String input) {
//        return ESCAPE_JSON.translate(input);
//    }
}
