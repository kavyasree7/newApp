/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.newapp.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.TypeMismatchException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.DownloadResponse;
import com.wavemaker.runtime.file.model.Downloadable;
import com.wavemaker.runtime.util.WMMultipartUtils;
import com.wavemaker.runtime.util.WMRuntimeUtils;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import com.newapp.Blobtypes;
import com.newapp.service.BlobtypesService;


/**
 * Controller object for domain model class Blobtypes.
 * @see Blobtypes
 */
@RestController("blobscenarios.BlobtypesController")
@Api(value = "BlobtypesController", description = "Exposes APIs to work with Blobtypes resource.")
@RequestMapping("/blobscenarios/Blobtypes")
public class BlobtypesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlobtypesController.class);

    @Autowired
	@Qualifier("blobscenarios.BlobtypesService")
	private BlobtypesService blobtypesService;

	@ApiOperation(value = "Creates a new Blobtypes instance.")
@RequestMapping(method = RequestMethod.POST, consumes = "multipart/form-data")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
public Blobtypes createBlobtypes(@RequestPart("wm_data_json") Blobtypes blobtypes, @RequestPart(value = "blobType1", required = false) MultipartFile _blobType1, @RequestPart(value = "blobType2", required = false) MultipartFile _blobType2, @RequestPart(value = "blobType3", required = false) MultipartFile _blobType3, @RequestPart(value = "blobType4", required = false) MultipartFile _blobType4, @RequestPart(value = "blobType5", required = false) MultipartFile _blobType5) {
		LOGGER.debug("Create Blobtypes with information: {}" , blobtypes);

    blobtypes.setBlobType1(WMMultipartUtils.toByteArray(_blobType1));
    blobtypes.setBlobType2(WMMultipartUtils.toByteArray(_blobType2));
    blobtypes.setBlobType3(WMMultipartUtils.toByteArray(_blobType3));
    blobtypes.setBlobType4(WMMultipartUtils.toByteArray(_blobType4));
    blobtypes.setBlobType5(WMMultipartUtils.toByteArray(_blobType5));
		blobtypes = blobtypesService.create(blobtypes);
		LOGGER.debug("Created Blobtypes with information: {}" , blobtypes);

	    return blobtypes;
	}

    @ApiOperation(value = "Returns the Blobtypes instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Blobtypes getBlobtypes(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting Blobtypes with id: {}" , id);

        Blobtypes foundBlobtypes = blobtypesService.getById(id);
        LOGGER.debug("Blobtypes details with id: {}" , foundBlobtypes);

        return foundBlobtypes;
    }

    @ApiOperation(value = "Retrieves content for the given BLOB field in Blobtypes instance" )
    @RequestMapping(value = "/{id}/content/{fieldName}", method = RequestMethod.GET, produces="application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public DownloadResponse getBlobtypesBLOBContent(@PathVariable("id") Integer id, @PathVariable("fieldName") String fieldName, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestParam(value="download", defaultValue = "false") boolean download) {

        LOGGER.debug("Retrieves content for the given BLOB field {} in Blobtypes instance" , fieldName);

        if(!WMRuntimeUtils.isLob(Blobtypes.class, fieldName)) {
            throw new TypeMismatchException("Given field " + fieldName + " is not a valid BLOB type");
        }
        Blobtypes blobtypes = blobtypesService.getById(id);

        return WMMultipartUtils.buildDownloadResponseForBlob(blobtypes, fieldName, httpServletRequest, download);
    }

    @ApiOperation(value = "Updates the Blobtypes instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Blobtypes editBlobtypes(@PathVariable("id") Integer id, @RequestBody Blobtypes blobtypes) throws EntityNotFoundException {
        LOGGER.debug("Editing Blobtypes with id: {}" , blobtypes.getPkId());

        blobtypes.setPkId(id);
        blobtypes = blobtypesService.update(blobtypes);
        LOGGER.debug("Blobtypes details with id: {}" , blobtypes);

        return blobtypes;
    }

    @ApiOperation(value = "Updates the Blobtypes instance associated with the given id.This API should be used when Blobtypes instance fields that require multipart data.") 
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.POST, consumes = {"multipart/form-data"})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Blobtypes editBlobtypes(@PathVariable("id") Integer id, MultipartHttpServletRequest multipartHttpServletRequest) throws EntityNotFoundException {
        Blobtypes newBlobtypes = WMMultipartUtils.toObject(multipartHttpServletRequest, Blobtypes.class, "blobscenarios");
        newBlobtypes.setPkId(id);

        Blobtypes oldBlobtypes = blobtypesService.getById(id);
        WMMultipartUtils.updateLobsContent(oldBlobtypes, newBlobtypes);
        LOGGER.debug("Updating Blobtypes with information: {}" , newBlobtypes);

        return blobtypesService.update(newBlobtypes);
    }

    @ApiOperation(value = "Deletes the Blobtypes instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteBlobtypes(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Blobtypes with id: {}" , id);

        Blobtypes deletedBlobtypes = blobtypesService.delete(id);

        return deletedBlobtypes != null;
    }

    /**
     * @deprecated Use {@link #findBlobtypes(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Blobtypes instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Blobtypes> searchBlobtypesByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Blobtypes list");
        return blobtypesService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Blobtypes instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Blobtypes> findBlobtypes(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Blobtypes list");
        return blobtypesService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Blobtypes instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Blobtypes> filterBlobtypes(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Blobtypes list");
        return blobtypesService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportBlobtypes(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return blobtypesService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of Blobtypes instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countBlobtypes( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting Blobtypes");
		return blobtypesService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getBlobtypesAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return blobtypesService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service BlobtypesService instance
	 */
	protected void setBlobtypesService(BlobtypesService service) {
		this.blobtypesService = service;
	}

}

