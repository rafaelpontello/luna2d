package com.rpontello.manager;

import com.rpontello.asset.Asset;

import java.util.ArrayList;
import java.util.List;

public class AssetManager {

    private static final List<Asset> ASSETS = new ArrayList<>();

    public static void add(Asset asset) {
        ASSETS.add(asset);
    }

    public static void init() {
        ASSETS.forEach(Asset::load);
    }



}
