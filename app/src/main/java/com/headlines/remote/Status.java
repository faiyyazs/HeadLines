package com.headlines.remote;

/**
 * Status of a resource that is provided to the UI.
 * <p>
 * These are usually created by the Repository classes where they return
 */
public enum Status {
    SUCCESS,
    ERROR,
    LOADING
}