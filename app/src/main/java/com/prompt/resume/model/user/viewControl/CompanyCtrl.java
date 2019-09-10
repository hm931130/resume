package com.prompt.resume.model.user.viewControl;

import android.view.View;

import com.prompt.resume.R;
import com.prompt.resume.databinding.ActCompanyAuthBinding;
import com.prompt.resume.databinding.ActInvitationAuthBinding;
import com.prompt.resume.model.user.viewModel.CompanyVM;
import com.prompt.resume.model.user.viewModel.InvitationVM;

/**
 * author ：hm
 * date : 2019/9/3 19:56
 * package：com.prompt.resume.model.user.viewControl
 * description :
 */
public class CompanyCtrl implements View.OnFocusChangeListener {
    private ActCompanyAuthBinding binding;

    private CompanyVM vm;

    public CompanyVM getVm() {
        return vm;
    }

    public CompanyCtrl(ActCompanyAuthBinding binding) {
        binding = binding;
        vm = new CompanyVM();

        binding.nameEt.setOnFocusChangeListener(this);
        binding.companyEt.setOnFocusChangeListener(this);
        binding.emailEt.setOnFocusChangeListener(this);
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (!hasFocus) {
            vm.setCompanyFocusable(false);
            vm.setNameFocusable(false);
            vm.setEmailFocusable(false);

            return;
        }
        switch (v.getId()) {
            case R.id.nameEt:
                vm.setNameFocusable(true);
                break;
            case R.id.companyEt:
                vm.setCompanyFocusable(true);
                break;
            case R.id.emailEt:
                vm.setEmailFocusable(true);
                break;
        }
    }
}
