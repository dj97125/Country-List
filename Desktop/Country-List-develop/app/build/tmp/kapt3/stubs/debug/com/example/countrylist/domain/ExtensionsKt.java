package com.example.countrylist.domain;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 2, d1 = {"\u0000N\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u001aP\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u001a\b\u0006\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00050\u00042\u001a\b\u0006\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00050\u0004H\u0086\b\u00f8\u0001\u0000\u001aA\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u0002H\u00020\b\"\u0004\b\u0000\u0010\u00022\u001c\u0010\n\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000bH\u0086@\u00f8\u0001\u0001\u00a2\u0006\u0002\u0010\u000e\u001a<\u0010\u000f\u001a\u00020\u0010\"\u0004\b\u0000\u0010\u0002*\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00100\u000b\u001a\n\u0010\u0017\u001a\u00020\t*\u00020\u0018\u0082\u0002\u000b\n\u0005\b\u009920\u0001\n\u0002\b\u0019\u00a8\u0006\u0019"}, d2 = {"countriesDiffUtil", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "T", "areItemsTheSame", "Lkotlin/Function2;", "", "areContentsTheSame", "tryCall", "Larrow/core/Either;", "Lcom/example/countrylist/Common/Error;", "action", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "launchAndCollect", "", "Landroidx/lifecycle/LifecycleOwner;", "flow", "Lkotlinx/coroutines/flow/Flow;", "state", "Landroidx/lifecycle/Lifecycle$State;", "body", "toError", "", "app_debug"})
public final class ExtensionsKt {
    
    @org.jetbrains.annotations.NotNull()
    public static final com.example.countrylist.Common.Error toError(@org.jetbrains.annotations.NotNull()
    java.lang.Throwable $this$toError) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final <T extends java.lang.Object>java.lang.Object tryCall(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> action, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super arrow.core.Either<? extends com.example.countrylist.Common.Error, ? extends T>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final <T extends java.lang.Object>androidx.recyclerview.widget.DiffUtil.ItemCallback<T> countriesDiffUtil(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super T, ? super T, java.lang.Boolean> areItemsTheSame, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super T, ? super T, java.lang.Boolean> areContentsTheSame) {
        return null;
    }
    
    public static final <T extends java.lang.Object>void launchAndCollect(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.LifecycleOwner $this$launchAndCollect, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull()
    androidx.lifecycle.Lifecycle.State state, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super T, kotlin.Unit> body) {
    }
}