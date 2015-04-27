/**********************************************************\
|                                                          |
|                          hprose                          |
|                                                          |
| Official WebSite: http://www.hprose.com/                 |
|                   http://www.hprose.org/                 |
|                                                          |
\**********************************************************/
/**********************************************************\
 *                                                        *
 * CalendarSerializer.java                                *
 *                                                        *
 * Calendar serializer class for Java.                    *
 *                                                        *
 * LastModified: Apr 26, 2015                             *
 * Author: Ma Bingyao <andot@hprose.com>                  *
 *                                                        *
\**********************************************************/

package hprose.io.serialize;

import hprose.io.HproseHelper;
import static hprose.io.HproseTags.TagSemicolon;
import static hprose.io.HproseTags.TagUTC;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.TimeZone;

final class CalendarSerializer implements HproseSerializer<Calendar> {

    public final static CalendarSerializer instance = new CalendarSerializer();

    public final static void write(OutputStream stream, WriterRefer refer, Calendar calendar) throws IOException {
        if (refer != null) refer.set(calendar);
        TimeZone tz = calendar.getTimeZone();
        if (!(tz.hasSameRules(HproseHelper.DefaultTZ) || tz.hasSameRules(HproseHelper.UTC))) {
            tz = HproseHelper.UTC;
            Calendar c = (Calendar) calendar.clone();
            c.setTimeZone(tz);
            calendar = c;
        }
        ValueWriter.writeDateOfCalendar(stream, calendar);
        ValueWriter.writeTimeOfCalendar(stream, calendar, true, false);
        stream.write(tz.hasSameRules(HproseHelper.UTC) ? TagUTC : TagSemicolon);
    }

    public final void write(HproseWriter writer, Calendar obj) throws IOException {
        OutputStream stream = writer.stream;
        WriterRefer refer = writer.refer;
        if (refer == null || !refer.write(stream, obj)) {
            write(stream, refer, obj);
        }
    }
}
