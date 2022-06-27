package com.example.countrylist.databinding;
import com.example.countrylist.R;
import com.example.countrylist.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class CountriesListCardViewBindingImpl extends CountriesListCardViewBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public CountriesListCardViewBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds));
    }
    private CountriesListCardViewBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.cardview.widget.CardView) bindings[0]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[1]
            , (android.widget.TextView) bindings[2]
            );
        this.cardView.setTag(null);
        this.tvCountryCapital.setTag(null);
        this.tvCountryCode.setTag(null);
        this.tvCountryName.setTag(null);
        this.tvCountryRegion.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.countries == variableId) {
            setCountries((com.example.countrylist.domain.Countries) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setCountries(@Nullable com.example.countrylist.domain.Countries Countries) {
        this.mCountries = Countries;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.countries);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.String countriesCapital = null;
        java.lang.String countriesName = null;
        java.lang.String countriesCode = null;
        java.lang.String countriesRegion = null;
        com.example.countrylist.domain.Countries countries = mCountries;

        if ((dirtyFlags & 0x3L) != 0) {



                if (countries != null) {
                    // read countries.capital
                    countriesCapital = countries.getCapital();
                    // read countries.name
                    countriesName = countries.getName();
                    // read countries.code
                    countriesCode = countries.getCode();
                    // read countries.region
                    countriesRegion = countries.getRegion();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvCountryCapital, countriesCapital);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvCountryCode, countriesCode);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvCountryName, countriesName);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvCountryRegion, countriesRegion);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): countries
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}