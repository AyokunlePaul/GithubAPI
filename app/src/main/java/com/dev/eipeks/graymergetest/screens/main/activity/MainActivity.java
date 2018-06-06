package com.dev.eipeks.graymergetest.screens.main.activity;

import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.dev.eipeks.graymergetest.MainApplication;
import com.dev.eipeks.graymergetest.R;
import com.dev.eipeks.graymergetest.core.api.models.RepositoryModel;
import com.dev.eipeks.graymergetest.core.dagger.components.AppComponent;
import com.dev.eipeks.graymergetest.databinding.ActivityMainBinding;
import com.dev.eipeks.graymergetest.screens.main.adapter.RepositoryRecyclerAdapter;
import com.dev.eipeks.graymergetest.screens.main.viewmodel.MainActivityViewModel;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private AppComponent component;

    @Inject
    MainActivityViewModel viewModel;

    private MainActivityViewModel.SearchTrendingRepositoryCallback trendingRepositoryCallback;

    private LinearLayoutManager manager;

    private RecyclerView.OnScrollListener scrollListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        component = MainApplication.get(this).getComponent();
        component.inject(this);

        initBinding();
        initCallbacks();

        viewModel.searchTrendingRepositories(trendingRepositoryCallback);
    }

    @Override
    public void onBackPressed() {
        if (binding.repositoryDetailsLink.getRoot().getVisibility() == View.VISIBLE){
            showRepositoryList();
            return;
        }
        super.onBackPressed();
    }

    private void initBinding(){
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        showErrorLayout("Magically getting popular repositories...");
        binding.repositoryListLink.getRoot().setVisibility(View.GONE);
    }

    private void hideAllViews(){
        binding.repositoryListLink.getRoot().setVisibility(View.GONE);
        binding.errorLayoutLink.getRoot().setVisibility(View.GONE);
        binding.repositoryDetailsLink.getRoot().setVisibility(View.GONE);
    }

    private void showErrorLayout(String message){
        Log.d("SHOW LAYOUT", message != null ? message : "NULL");
        hideAllViews();
        binding.errorLayoutLink.getRoot().setVisibility(View.VISIBLE);
        binding.errorLayoutLink.setErrorMessage(message);
    }

    private void showRepositoryList(){
        hideAllViews();
        binding.repositoryListLink.getRoot().setVisibility(View.VISIBLE);
        binding.repositoryListLink.repositoryList.setLayoutManager(manager);
        binding.repositoryListLink.repositoryList.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));
    }

    private void showDetailedRepositoryInformation(RepositoryModel model){
        hideAllViews();
        binding.repositoryDetailsLink.setModel(model);
        binding.repositoryDetailsLink.getRoot().setVisibility(View.VISIBLE);
        binding.repositoryDetailsLink.organizationAvatar.setImageURI(Uri.parse(model.getOwner().getAvatarUrl()));
    }

    private void setUpRecyclerView(List<RepositoryModel> repositoryModels){
        RepositoryRecyclerAdapter adapter = new RepositoryRecyclerAdapter(repositoryModels);
        adapter.setRepositoryItemClickListener(new RepositoryRecyclerAdapter.OnRepositoryItemClickListener() {
            @Override
            public void onRepositoryItemClicked(RepositoryModel model) {
                //Perform some programmatic abracadabra
                showDetailedRepositoryInformation(model);
            }
        });
//        scrollListener = new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
//                super.onScrollStateChanged(recyclerView, newState);
//            }
//
//            @Override
//            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
//                super.onScrolled(recyclerView, dx, dy);
//            }
//        };
        manager = new LinearLayoutManager(this);
        binding.repositoryListLink.repositoryList.setAdapter(adapter);
        showRepositoryList();
    }

    private void initCallbacks(){
        trendingRepositoryCallback = new MainActivityViewModel.SearchTrendingRepositoryCallback() {
            @Override
            public void onSearchQuerySuccessful(List<RepositoryModel> repositoryModels) {
                Log.d("SHOW LAYOUT", "onSearchQuerySuccessful ====== " + repositoryModels.size());
                setUpRecyclerView(repositoryModels);
            }

            @Override
            public void onHttpExceptionOccur(String errorMessage) {
                Log.d("SHOW LAYOUT", "onHttpExceptionOccur");
                showErrorLayout(errorMessage);
            }

            @Override
            public void onErrorOccurred(Throwable throwable) {
                Log.d("SHOW LAYOUT", throwable.toString());
                showErrorLayout(throwable.getLocalizedMessage());
            }
        };
    }
}
