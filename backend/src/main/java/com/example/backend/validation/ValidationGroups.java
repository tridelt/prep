package com.example.backend.validation;

import jakarta.validation.groups.Default;

public interface ValidationGroups {

    interface IdentityPresent {
    }

    interface IdentityNull extends Default {
    }

}
