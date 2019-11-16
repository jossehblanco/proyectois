import { TestBed } from '@angular/core/testing';

import { IsapiService } from './isapi.service';

describe('IsapiService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: IsapiService = TestBed.get(IsapiService);
    expect(service).toBeTruthy();
  });
});
