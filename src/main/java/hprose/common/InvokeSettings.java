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
 * InvokeSettings.java                                    *
 *                                                        *
 * hprose invoke settings class for Java.                 *
 *                                                        *
 * LastModified: Apr 23, 2016                             *
 * Author: Ma Bingyao <andot@hprose.com>                  *
 *                                                        *
\**********************************************************/
package hprose.common;

import java.lang.reflect.Type;

public final class InvokeSettings {
    private HproseResultMode mode = HproseResultMode.Normal;
    private boolean async = false;
    private Boolean byref = null;
    private Boolean simple = null;
    private Boolean idempotent = null;
    private Boolean failswitch = null;
    private Boolean oneway = null;
    private Integer retry = null;
    private Type type = null;

    public HproseResultMode getMode() {
        return mode;
    }

    public void setMode(HproseResultMode mode) {
        this.mode = mode;
    }

    public boolean isByref() {
        return byref;
    }

    public void setByref(boolean byRef) {
        this.byref = byRef;
    }

    public boolean isSimple() {
        return simple;
    }

    public void setSimple(boolean simple) {
        this.simple = simple;
    }

    public boolean isIdempotent() {
        return idempotent;
    }

    public void setIdempotent(boolean idempotent) {
        this.idempotent = idempotent;
    }

    public boolean isFailswitch() {
        return failswitch;
    }

    public void setFailswitch(boolean failswitch) {
        this.failswitch = failswitch;
    }

    public int getRetry() {
        return retry;
    }

    public void setRetry(int retry) {
        this.retry = retry;
    }

    public boolean isOneway() {
        return oneway;
    }

    public void setOneway(boolean oneway) {
        this.oneway = oneway;
    }

    public Type getReturnType() {
        return type;
    }

    public void setReturnType(Type type) {
        this.type = type;
    }

    public boolean isAsync() {
        return async;
    }

    public void setAsync(boolean async) {
        this.async = async;
    }

    public void copyFrom(InvokeSettings settings) {
        mode = settings.mode;
        async = settings.async;
        if (settings.byref != null) byref = settings.byref;
        if (settings.simple != null) simple = settings.simple;
        if (settings.failswitch != null) failswitch = settings.failswitch;
        if (settings.idempotent != null) idempotent = settings.idempotent;
        if (settings.oneway != null) oneway = settings.oneway;
        if (settings.retry != null) retry = settings.retry;
        if (settings.type != null) type = settings.type;
    }
}
