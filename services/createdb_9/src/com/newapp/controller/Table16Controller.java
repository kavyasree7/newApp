/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.newapp.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.util.Map;

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
import org.springframework.web.bind.annotation.RestController;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import com.newapp.Table16;
import com.newapp.service.Table16Service;


/**
 * Controller object for domain model class Table16.
 * @see Table16
 */
@RestController("createdb_9.Table16Controller")
@Api(value = "Table16Controller", description = "Exposes APIs to work with Table16 resource.")
@RequestMapping("/createdb_9/Table16")
public class Table16Controller {

    private static final Logger LOGGER = LoggerFactory.getLogger(Table16Controller.class);

    @Autowired
	@Qualifier("createdb_9.Table16Service")
	private Table16Service table16Service;

	@ApiOperation(value = "Creates a new Table16 instance.")
@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
public Table16 createTable16(@RequestBody Table16 table16) {
		LOGGER.debug("Create Table16 with information: {}" , table16);

		table16 = table16Service.create(table16);
		LOGGER.debug("Created Table16 with information: {}" , table16);

	    return table16;
	}

    @ApiOperation(value = "Returns the Table16 instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Table16 getTable16(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting Table16 with id: {}" , id);

        Table16 foundTable16 = table16Service.getById(id);
        LOGGER.debug("Table16 details with id: {}" , foundTable16);

        return foundTable16;
    }

    @ApiOperation(value = "Updates the Table16 instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Table16 editTable16(@PathVariable("id") Integer id, @RequestBody Table16 table16) throws EntityNotFoundException {
        LOGGER.debug("Editing Table16 with id: {}" , table16.getId());

        table16.setId(id);
        table16 = table16Service.update(table16);
        LOGGER.debug("Table16 details with id: {}" , table16);

        return table16;
    }

    @ApiOperation(value = "Deletes the Table16 instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteTable16(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Table16 with id: {}" , id);

        Table16 deletedTable16 = table16Service.delete(id);

        return deletedTable16 != null;
    }

    /**
     * @deprecated Use {@link #findTable16s(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Table16 instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Table16> searchTable16sByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Table16s list");
        return table16Service.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Table16 instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Table16> findTable16s(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Table16s list");
        return table16Service.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Table16 instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Table16> filterTable16s(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Table16s list");
        return table16Service.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportTable16s(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return table16Service.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of Table16 instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countTable16s( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting Table16s");
		return table16Service.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getTable16AggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return table16Service.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service Table16Service instance
	 */
	protected void setTable16Service(Table16Service service) {
		this.table16Service = service;
	}

}

