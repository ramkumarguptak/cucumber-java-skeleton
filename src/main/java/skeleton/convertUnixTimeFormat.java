/**
 * Created by rmanchi on 27/11/2016.
 */

package skeleton;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class convertUnixTimeFormat {


        public static String UnixTimeToDateTime(long unixtime)
        {
            Date date = new Date(unixtime*1000L); // *1000 is to convert seconds to milliseconds
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z"); // the format of your date
            sdf.setTimeZone(TimeZone.getTimeZone("GMT-4"));
            String formattedDate = sdf.format(date);
            return formattedDate;
        }

    }

