package com.example.countrylist.Common;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007\u00a8\u0006\b"}, d2 = {"Lcom/example/countrylist/Common/Error;", "", "Connectivity", "Server", "Unknown", "Lcom/example/countrylist/Common/Error$Server;", "Lcom/example/countrylist/Common/Error$Connectivity;", "Lcom/example/countrylist/Common/Error$Unknown;", "app_debug"})
public abstract interface Error {
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/example/countrylist/Common/Error$Server;", "Lcom/example/countrylist/Common/Error;", "code", "", "(I)V", "getCode", "()I", "app_debug"})
    public static final class Server implements com.example.countrylist.Common.Error {
        private final int code = 0;
        
        public Server(int code) {
            super();
        }
        
        public final int getCode() {
            return 0;
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/countrylist/Common/Error$Connectivity;", "Lcom/example/countrylist/Common/Error;", "()V", "app_debug"})
    public static final class Connectivity implements com.example.countrylist.Common.Error {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.countrylist.Common.Error.Connectivity INSTANCE = null;
        
        private Connectivity() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/example/countrylist/Common/Error$Unknown;", "Lcom/example/countrylist/Common/Error;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "app_debug"})
    public static final class Unknown implements com.example.countrylist.Common.Error {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String message = null;
        
        public Unknown(@org.jetbrains.annotations.NotNull()
        java.lang.String message) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getMessage() {
            return null;
        }
    }
}