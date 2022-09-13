package service;

import model.Building;

public interface PrintService {
    int SEPARATOR_LENGTH = 3;
    void print(Building building);

    static StringBuilder addSpacesToRequiredLength(String s, int requiredLength) {
        StringBuilder stringBuilder = new StringBuilder(s);
        for (int i = s.length(); i <= requiredLength; i++) {
            stringBuilder.append(" ");
        }
        return stringBuilder;
    }
}
